package com.event.manager.microservice.ReservationService.repository;

import com.event.manager.microservice.ReservationService.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("Select r from Reservation r Where r.userId = :userId")
    List<Reservation> findReservationsByUserId(String userId);
}
