package com.event.manager.microservice.ReservationService.service;


import com.event.manager.microservice.ReservationService.dto.ReservationDto;
import com.event.manager.microservice.ReservationService.exception.NotFoundException;
import com.event.manager.microservice.ReservationService.model.Reservation;
import com.event.manager.microservice.ReservationService.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final ModelMapper modelMapper;

    public Reservation findReservationByIdWithCheck(long id){
        return reservationRepository.findById(id).orElseThrow(()->new
                NotFoundException("No Reservation With this id "+id));
    }

    public void createReservation(ReservationDto reservationDto){
        Reservation reservation = modelMapper.map(reservationDto, Reservation.class);

        // must check if the time of the event is applicable with reservation date before saving
        reservation.setReservationTime(LocalDateTime.now());
        reservationRepository.save(reservation);
    }

    // get reservation events...
    public void getReservationsEvents(String userId){
        // all reservations of userId
        List<Reservation> reservations =  reservationRepository.
                findReservationsByUserId(userId);

        // get event details
        /*
        * {
        *   id
        *   event details
        * }
        */
        // return list of reservation details
    }

    public void deleteReservation(long id){
        Reservation reservation =  findReservationByIdWithCheck(id);
        reservationRepository.delete(reservation);
    }


}
