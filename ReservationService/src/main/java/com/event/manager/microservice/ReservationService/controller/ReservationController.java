package com.event.manager.microservice.ReservationService.controller;

import com.event.manager.microservice.ReservationService.dto.ReservationDto;
import com.event.manager.microservice.ReservationService.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/v1/reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;


    @PostMapping
    public void createReservation(ReservationDto reservationDto){
        reservationService.createReservation(reservationDto);
    }


    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable long id){
        reservationService.deleteReservation(id);
    }
}
