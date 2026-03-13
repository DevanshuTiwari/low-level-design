package com.lowleveldesign.ticket_booking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Seat {
    Long id;
    String seatNumber;

    @ManyToOne
    Screen screen;
}
