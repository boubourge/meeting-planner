package com.sncf.meetingplanner.api;

import com.sncf.meetingplanner.Reservation;
import com.sncf.meetingplanner.ReunionType;
import com.sncf.meetingplanner.Room;
import com.sncf.meetingplanner.model.mappers.ReunionMapper;
import com.sncf.meetingplanner.model.mappers.RoomMapper;
import com.sncf.meetingplanner.services.RoomService;
import lombok.AllArgsConstructor;
import org.openapitools.api.PlanningApi;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
public class PlanningApiImpl implements PlanningApi {

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
        var reunionDateTime = reunionDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        var reunionTypeModel = reunionMapper.reunionTypeDtoToReunionTypeModel(reunionType);
        var listeFreeRooms = roomService.getFreeRoomsForMeeting(reunionDateTime, reunionTypeModel, participantNumber);
        return roomMapper.mapRoomModelListToRoomDtoList(listeFreeRooms);
    }
}
