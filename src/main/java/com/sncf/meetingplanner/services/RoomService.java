package com.sncf.meetingplanner.services;

import com.sncf.meetingplanner.model.Room;
import com.sncf.meetingplanner.model.enums.ReunionType;
import com.sncf.meetingplanner.model.mappers.RoomMapper;
import com.sncf.meetingplanner.persistence.RoomServicePersistence;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static com.sncf.meetingplanner.model.enums.MaterialType.*;

@Service
@AllArgsConstructor
public class RoomService {

    private static final Logger log = LoggerFactory.getLogger(RoomService.class);

    @Autowired
    private RoomServicePersistence roomServicePersistence;

    @Autowired
    private RoomMapper roomMapper;

    /**
     * Recuperation of the free rooms by date and hour, type of reunion and number of participants
     *
     * @param reunionDate the date of the reunion
     * @param reunionType the type of the reunion
     * @param participantNumber the number of participants for the reunion
     *
     * @return the list of the free rooms
     */
    public List<Room> getFreeRoomsForMeeting(LocalDateTime reunionDate, ReunionType reunionType, Integer participantNumber) {

        // Recuperation of the disponible rooms for the hours
        var disponibleRooms = roomMapper.mapRoomEntityListToRoomModelList(
                roomServicePersistence.retrieveDisponibleRoom(reunionDate, reunionDate.plusHours(2)));

        // Exclusion of the rooms that have not the material for the reunion type
        // or that are too small (COVID = 70%)
        // and return
        return excludeNonCompatibleRooms(disponibleRooms, reunionType, participantNumber);
    }

    /**
     * Exclusion of the non-compatibles rooms (capacity and material)
     *
     * @param disponibleRooms the disponible rooms for the hours of the reunion
     * @param reunionType the type of the reunion
     * @param participantNumber the number of participants for the reunion
     *
     * @return a new list with only compatible rooms
     */
    private List<Room> excludeNonCompatibleRooms(List<Room> disponibleRooms, ReunionType reunionType, Integer participantNumber) {

        var disponibleRoomsIterator = disponibleRooms.iterator();
        while (disponibleRoomsIterator.hasNext()) {

            var room = disponibleRoomsIterator.next();

            // Check of the capacity and the material of the room
            var isCapacityOk = checkRoomCapacity(room, participantNumber);
            var isMaterialOk = checkRoomsForReunionType(room, reunionType);

            // If the room is not compatible, we remove it of the list
            if (!isCapacityOk || !isMaterialOk) {
                log.debug("Salle {} non compatible - Capacité : {} / matériel : {}", room.getName(), isCapacityOk, isMaterialOk);
                disponibleRoomsIterator.remove();
            }
        }
        return disponibleRooms;
    }

    /**
     * Check of the room capacity
     *
     * @param room the checked room
     * @param participantNumber the number of participants
     *
     * @return if the room is ok
     */
    private Boolean checkRoomCapacity(Room room, Integer participantNumber) {
        // The order in important because Integer (<100) / 100 = 0
        var covidCapacity = room.getCapacity() * 70 / 100;
        return participantNumber < covidCapacity;
    }

    /**
     * Check of the room material
     *
     * @param room the checked room
     * @param reunionType the type of reunion
     *
     * @return if the room is ok
     */
    private Boolean checkRoomsForReunionType(Room room, ReunionType reunionType) {
        var roomMaterial = room.getMaterial();
        return switch (reunionType) {
            case VC -> roomMaterial.contains(ECRAN) && roomMaterial.contains(PIEUVRE) && roomMaterial.contains(WEBCAM);
            case SPEC -> roomMaterial.contains(TABLEAU);
            case RS -> Boolean.TRUE;
            case RC -> roomMaterial.contains(TABLEAU) && roomMaterial.contains(ECRAN) && roomMaterial.contains(PIEUVRE);
        };
    }
}
