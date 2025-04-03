package com.sncf.meetingplanner.controllers;

import com.sncf.meetingplanner.Reservation;
import lombok.AllArgsConstructor;
import org.openapitools.api.ReservationApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class Reservationcontroller implements ReservationApi {

    @Override
    public ResponseEntity<Reservation> addReservation(Reservation reservation) {
        return null;
    }

    @Override
    public ResponseEntity<Reservation> deleteReservation(Integer reservationId) {
        return null;
    }

    @Override
    public ResponseEntity<Reservation> getReservation(Integer reservationId) {
        return null;
    }

    @Override
    public ResponseEntity<Reservation> putReservation(Reservation reservation) {
        return null;
    }
}
