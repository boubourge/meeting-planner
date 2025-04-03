package com.sncf.meetingplanner.persistence;

import com.sncf.meetingplanner.persistence.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Repository
public interface RoomServicePersistence extends JpaRepository<Room, String> {

    public static final String SELECT_DISPONIBLE_ROOM = "SELECT r FROM Room r " +
            "LEFT JOIN Reservation res ON r.name = res.roomName " +
            "WHERE res.reservationDate is null " +
            "or res.reservationDate NOT BETWEEN :startDate AND :endDate";

    @Query(SELECT_DISPONIBLE_ROOM)
    List<Room> retrieveDisponibleRoom(@Param("startDate") OffsetDateTime startDate, @Param("endDate") OffsetDateTime endDate);
}
