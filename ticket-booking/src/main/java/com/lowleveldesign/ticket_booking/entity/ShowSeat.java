package com.lowleveldesign.ticket_booking.entity;

import com.lowleveldesign.ticket_booking.enums.ShowSeatStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;

@Entity
public class ShowSeat {
    Long id;

    @ManyToOne
    Show show;

    @ManyToOne
    Seat seat;

    ShowSeatStatus showSeatStatus;
    BigDecimal ticketPrice;
}
