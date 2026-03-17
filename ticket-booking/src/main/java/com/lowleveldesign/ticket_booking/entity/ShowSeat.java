package com.lowleveldesign.ticket_booking.entity;

import com.lowleveldesign.ticket_booking.enums.ShowSeatStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Version;

import java.math.BigDecimal;

@Entity
public class ShowSeat {
    Long id;

    @ManyToOne
    Show show;

    @ManyToOne
    Seat seat;

    @ManyToOne(fetch = FetchType.LAZY)
    Booking booking;

    @Version
    Long version;

    ShowSeatStatus showSeatStatus;
    BigDecimal ticketPrice;
}
