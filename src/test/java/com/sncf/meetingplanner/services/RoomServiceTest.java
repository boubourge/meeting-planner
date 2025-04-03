package com.sncf.meetingplanner.services;

import com.sncf.meetingplanner.model.enums.ReunionType;
import com.sncf.meetingplanner.model.mappers.RoomMapper;
import com.sncf.meetingplanner.persistence.RoomServicePersistence;
import com.sncf.meetingplanner.persistence.entities.Room;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import static com.sncf.meetingplanner.model.enums.MaterialType.*;
import static com.sncf.meetingplanner.model.enums.ReunionType.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RoomServiceTest {

    @Mock
    RoomServicePersistence roomServicePersistence;

    @Mock
    RoomMapper roomMapper;

    @InjectMocks
    RoomService roomService;

    @ParameterizedTest
    @EnumSource(ReunionType.class)
    void getFreeRoomsForMeetingTest(ReunionType reunionType) {

        // Given
        var startDate = OffsetDateTime.of(2025, 2, 4, 18, 26,0, 0, ZoneOffset.UTC);
        var endDate = startDate.plusHours(2);
        var listBDD = new ArrayList<Room>();

        var room1 = new com.sncf.meetingplanner.model.Room();
        room1.setName("E1001");
        room1.setCapacity(10);
        room1.setMaterial(new ArrayList<>());

        var room2 = new com.sncf.meetingplanner.model.Room();
        room2.setName("E1002");
        room2.setCapacity(8);
        room2.setMaterial(List.of(ECRAN));

        var room3 = new com.sncf.meetingplanner.model.Room();
        room3.setName("E1003");
        room3.setCapacity(20);
        room3.setMaterial(List.of(PIEUVRE));

        var room4 = new com.sncf.meetingplanner.model.Room();
        room4.setName("E1004");
        room4.setCapacity(15);
        room4.setMaterial(List.of(TABLEAU));

        var mapedList = new ArrayList<com.sncf.meetingplanner.model.Room>();
        mapedList.add(room1);
        mapedList.add(room2);
        mapedList.add(room3);
        mapedList.add(room4);

        when(roomServicePersistence.retrieveDisponibleRoom(startDate, endDate)).thenReturn(listBDD);
        when(roomMapper.mapRoomEntityListToRoomModelList(listBDD)).thenReturn(mapedList);

        // When
        var result = roomService.getFreeRoomsForMeeting(startDate, reunionType, 9);

        // Then
        if (VC.equals(reunionType)) {
            assertEquals(0, result.size());
        }
        if (SPEC.equals(reunionType)) {
            assertEquals(1, result.size());
            assertEquals("E1004", result.get(0).getName());
        }
        if (RS.equals(reunionType)) {
            assertEquals(2, result.size());
            assertEquals("E1003", result.get(0).getName());
            assertEquals("E1004", result.get(1).getName());
        }
        if (RC.equals(reunionType)) {
            assertEquals(0, result.size());
        }
    }
}
