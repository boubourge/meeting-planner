package com.sncf.meetingplanner.model.mappers;

import com.sncf.meetingplanner.Material;
import com.sncf.meetingplanner.model.Room;
import com.sncf.meetingplanner.model.enums.MaterialType;
import com.sncf.meetingplanner.persistence.entities.RoomEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ValueMapping;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface RoomMapper {

    /* ************************* */
    /* ROOM ENTITY to ROOM MODEL */
    /* ************************* */

    @Mapping(target = "name", source = "name")
    @Mapping(target = "capacity", source = "capacity")
    @Mapping(target = "material", source = "material")
    Room mapRoomEntityToRoomModel(RoomEntity roomEntity);

    ArrayList<Room> mapRoomEntityListToRoomModelList(List<RoomEntity> roomEntity);

    @ValueMapping(target = "ECRAN", source = "ECRAN")
    @ValueMapping(target = "PIEUVRE", source = "PIEUVRE")
    @ValueMapping(target = "TABLEAU", source = "TABLEAU")
    @ValueMapping(target = "WEBCAM", source = "WEBCAM")
    MaterialType materialTypeModelToMaterialType(com.sncf.meetingplanner.persistence.entities.enums.MaterialType materialType);

    List<MaterialType> materialTypeModelListToListMaterialType(List<com.sncf.meetingplanner.persistence.entities.enums.MaterialType> materialTypes);

    /* ********************** */
    /* ROOM MODEL to ROOM DTO */
    /* ********************** */

    @Mapping(target = "name", source = "name")
    @Mapping(target = "capacity", source = "capacity")
    @Mapping(target = "material", source = "material")
    com.sncf.meetingplanner.Room mapRoomModelToRoomDto(Room room);

    List<com.sncf.meetingplanner.Room> mapRoomModelListToRoomDtoList(List<Room> rooms);

    @ValueMapping(target = "ECRAN", source = "ECRAN")
    @ValueMapping(target = "PIEUVRE", source = "PIEUVRE")
    @ValueMapping(target = "TABLEAU", source = "TABLEAU")
    @ValueMapping(target = "WEBCAM", source = "WEBCAM")
    Material materialTypeModelToMaterialDto(MaterialType materialType);

    List<Material> materialTypeModelListToMaterialDtoList(List<MaterialType> materialTypes);

}
