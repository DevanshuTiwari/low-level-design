package com.lowleveldesign.ticket_booking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Screen {
    Long id;
    String name;

    @ManyToOne
    Theatre theatre;
}
