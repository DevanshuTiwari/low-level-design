package com.lowleveldesign.ticket_booking.service;

import com.lowleveldesign.ticket_booking.entity.Booking;
import com.lowleveldesign.ticket_booking.entity.Seat;
import com.lowleveldesign.ticket_booking.entity.ShowSeat;
import com.lowleveldesign.ticket_booking.enums.BookingStatus;
import com.lowleveldesign.ticket_booking.enums.ShowSeatStatus;
import com.lowleveldesign.ticket_booking.repository.BookingRepository;
import com.lowleveldesign.ticket_booking.repository.ShowSeatRepository;
import jakarta.transaction.Transactional;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final ShowSeatRepository showSeatRepository;

    public BookingServiceImpl(BookingRepository bookingRepository, ShowSeatRepository showSeatRepository) {
        this.bookingRepository = bookingRepository;
        this.showSeatRepository = showSeatRepository;
    }

    @Transactional
    @Override
    public Booking createBooking(Long userId, Long showId, List<Long> showSeatIds) {
        List<ShowSeat> seats = showSeatRepository.findByIdInAndShowId(showSeatIds, showId);

        if (seats.size() != showSeatIds.size()) {
            throw new IllegalArgumentException("Some of the requested seats are invalid or do not belong to this show");
        }

        for (ShowSeat seat : seats) {
            if (seat.getShowSeatStatus() != ShowSeatStatus.AVAILABLE) {
                throw new IllegalStateException("Seat " + seat.getSeat().getSeatNumber() + "is no longer available ");
            }

            seat.setShowSeatStatus(ShowSeatStatus.LOCKED);
        }

        showSeatRepository.saveAll(seats);

        Booking booking = new Booking();

        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setBookingTime(LocalDateTime.now());

        BigDecimal totalAmount = BigDecimal.ZERO;
        for (ShowSeat seat : seats) {
            totalAmount = totalAmount.add(seat.getTicketPrice());
            seat.setBooking(booking);
        }

        booking.setTotalAmount(totalAmount);

        booking.setSeats(seats);

        return bookingRepository.save(booking);
    }

    @Scheduled(fixedRate = 60000)
    @Transactional
    public void releaseExpiredBookings() {
        LocalDateTime tenMinutesTime = LocalDateTime.now().minusMinutes(10);
        List<Booking> expiredBookings = bookingRepository.findBookingByStatusAndCreatedAt(BookingStatus.PENDING, tenMinutesTime);

        if (expiredBookings.isEmpty()) {
            return;
        }

        for (Booking booking : expiredBookings) {
            booking.setBookingStatus(BookingStatus.FAILED);

            for (ShowSeat seat : booking.getSeats()) {
                seat.setShowSeatStatus(ShowSeatStatus.AVAILABLE);
                seat.setBooking(null); // failed booking
            }
        }

        bookingRepository.saveAll(expiredBookings);

    }
}