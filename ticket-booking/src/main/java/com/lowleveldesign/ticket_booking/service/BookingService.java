package com.lowleveldesign.ticket_booking.service;

import com.lowleveldesign.ticket_booking.entity.Booking;

import java.util.List;

public interface BookingService {
    Booking createBooking(Long userId, Long showId, List<Long> showSeatIds);

    void releaseExpiredBookings();
}
