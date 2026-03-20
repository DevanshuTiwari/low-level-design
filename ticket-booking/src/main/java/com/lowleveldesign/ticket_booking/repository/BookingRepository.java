package com.lowleveldesign.ticket_booking.repository;

import com.lowleveldesign.ticket_booking.entity.Booking;
import com.lowleveldesign.ticket_booking.enums.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findBookingByStatusAndCreatedAt(BookingStatus bookingStatus, LocalDateTime time);

}
