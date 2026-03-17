package com.lowleveldesign.ticket_booking.entity;

import com.lowleveldesign.ticket_booking.enums.BookingStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Booking {
    Long id;

    @ManyToOne
    User user;

    @ManyToOne
    Show show;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    List<ShowSeat> seats;

    BookingStatus bookingStatus;
    BigDecimal totalAmount;
    LocalDateTime bookingTime;
}
