package com.sncf.meetingplanner.controllers;

import com.sncf.meetingplanner.Reservation;
import lombok.AllArgsConstructor;
import org.openapitools.api.ReservationApi;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class Reservationcontroller implements ReservationApi {

    @Override
    public Reservation addReservation(Reservation reservation) {
        return null;
    }

    @Override
    public Reservation deleteReservation(Integer reservationId) {
        return null;
    }

    @Override
    public Reservation getReservation(Integer reservationId) {
        return null;
    }

    @Override
    public Reservation putReservation(Reservation reservation) {
        return null;
    }
}
