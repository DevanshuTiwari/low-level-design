package com.lowleveldesign.ticket_booking.repository;

import com.lowleveldesign.ticket_booking.entity.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
    List<ShowSeat> findByIdInAndShowId(List<Long> showSeatIds, Long showId);
}