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
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;

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
    public List<Reservation> getPlanning(Integer timeSlot) {
        return List.of();
    }

    @Override
    public List<Room> getFreeRooms(Date reunionDate, ReunionType reunionType, Integer participantNumber) {

        log.info("Check of free rooms for a {} reunion whith {} participants at the date : {}", reunionType.name(), participantNumber, reunionDate);

        // Mapping of the entry values
        var reunionDateTime = reunionDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        var reunionTypeModel = reunionMapper.reunionTypeDtoToReunionTypeModel(reunionType);

        // Call of the service
        var listeFreeRooms = roomService.getFreeRoomsForMeeting(reunionDateTime, reunionTypeModel, participantNumber);

        return roomMapper.mapRoomModelListToRoomDtoList(listeFreeRooms);
    }
}
