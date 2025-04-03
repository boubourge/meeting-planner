package com.sncf.meetingplanner.controllers;

import com.sncf.meetingplanner.Reservation;
import com.sncf.meetingplanner.ReunionType;
import com.sncf.meetingplanner.Room;
import com.sncf.meetingplanner.model.mappers.ReunionMapper;
import com.sncf.meetingplanner.model.mappers.RoomMapper;
import com.sncf.meetingplanner.services.RoomService;
import lombok.AllArgsConstructor;
import org.openapitools.api.PlanningApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class PlanningController implements PlanningApi {

    private static final Logger log = LoggerFactory.getLogger(PlanningController.class);

    @Autowired
    private RoomService roomService;

    @Autowired
    private RoomMapper roomMapper;

    @Autowired
    private ReunionMapper reunionMapper;

    @Override
    public ResponseEntity<List<Reservation>> getPlanning(Integer timeSlot) {
        return null;
    }

    @Override
    public ResponseEntity<List<Room>> getFreeRooms(OffsetDateTime reunionDate, ReunionType reunionType, Integer participantNumber) {

        log.info("Check of free rooms for a {} reunion with {} participants at the date : {}", reunionType.name(), participantNumber, reunionDate);

        // Mapping and Conversion of the entry values
        var reunionTypeModel = reunionMapper.reunionTypeDtoToReunionTypeModel(reunionType);

        // Call the service
        var listeFreeRooms = roomService.getFreeRoomsForMeeting(reunionDate, reunionTypeModel, participantNumber);

        return ResponseEntity.of(Optional.ofNullable(roomMapper.mapRoomModelListToRoomDtoList(listeFreeRooms)));
    }
}
