package com.lowleveldesign.ticket_booking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class Show {
    Long id;

    @ManyToOne
    Movie movie;

    @ManyToOne
    Screen screen;

    LocalDateTime startTime;
}
