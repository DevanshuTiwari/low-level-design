package com.lowleveldesign.ticket_booking.entity;

import com.lowleveldesign.ticket_booking.enums.BookingStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Booking {
    Long id;

    @ManyToOne
    User user;

    @ManyToOne
    Show show;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    List<ShowSeat> seats;

    BookingStatus bookingStatus;

    LocalDateTime bookingTime;
}
