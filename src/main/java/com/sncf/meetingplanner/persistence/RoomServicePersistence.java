package com.sncf.meetingplanner.persistence;

import com.sncf.meetingplanner.persistence.entities.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RoomServicePersistence extends JpaRepository<RoomEntity, String> {

    public static final String SELECT_DISPONIBLE_ROOM = "SELECT room FROM room " +
            "INNER JOIN reservation ON room.name = reservation.roomName " +
            "WHERE reservation.reservationdate NOT BETWEEN :startDate AND :endDate";

    @Query(SELECT_DISPONIBLE_ROOM)
    List<RoomEntity> retrieveDisponibleRoom(@Param("dateDebut") LocalDateTime startDate, @Param("dateFin") LocalDateTime endDate);
}
