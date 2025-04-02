package com.sncf.meetingplanner.model.mappers;

import com.sncf.meetingplanner.persistence.entities.Room;
import com.sncf.meetingplanner.persistence.entities.enums.MaterialType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.sncf.meetingplanner.model.enums.MaterialType.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RoomMapperTest {

    @Test
    void mapRoomEntityListToRoomModelListTest() {

        // Given
        RoomMapper roomMapper = new RoomMapperImpl();

        var roomEntity1 = new Room();
        roomEntity1.setName("E1002");
        roomEntity1.setCapacity(8);
        roomEntity1.setMaterial(List.of(MaterialType.ECRAN));

        var roomEntity2 = new Room();
        roomEntity2.setName("E1003");
        roomEntity2.setCapacity(10);
        roomEntity2.setMaterial(List.of(MaterialType.TABLEAU, MaterialType.PIEUVRE));

        var roomEntity3 = new Room();
        roomEntity3.setName("E1004");
        roomEntity3.setCapacity(12);
        roomEntity3.setMaterial(List.of(MaterialType.WEBCAM));

        // When
        var result = roomMapper.mapRoomEntityListToRoomModelList(List.of(roomEntity1, roomEntity2, roomEntity3));

        // Then
        assertEquals(3, result.size());

        var roomModel1 = result.get(0);
        assertEquals("E1002", roomModel1.getName());
        assertEquals(8, roomModel1.getCapacity());
        assertEquals(1, roomModel1.getMaterial().size());
        assertEquals(ECRAN, roomModel1.getMaterial().get(0));

        var roomModel2 = result.get(1);
        assertEquals("E1003", roomModel2.getName());
        assertEquals(10, roomModel2.getCapacity());
        assertEquals(2, roomModel2.getMaterial().size());
        assertEquals(TABLEAU, roomModel2.getMaterial().get(0));
        assertEquals(PIEUVRE, roomModel2.getMaterial().get(1));

        var roomModel3 = result.get(2);
        assertEquals("E1004", roomModel3.getName());
        assertEquals(12, roomModel3.getCapacity());
        assertEquals(1, roomModel3.getMaterial().size());
        assertEquals(WEBCAM, roomModel3.getMaterial().get(0));
    }
}
