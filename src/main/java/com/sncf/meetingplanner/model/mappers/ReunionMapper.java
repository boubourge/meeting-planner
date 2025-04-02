package com.sncf.meetingplanner.model.mappers;

import com.sncf.meetingplanner.model.enums.ReunionType;
import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;

@Mapper
public interface ReunionMapper {

    @ValueMapping(target = "VC", source = "VC")
    @ValueMapping(target = "SPEC", source = "SPEC")
    @ValueMapping(target = "RS", source = "RS")
    @ValueMapping(target = "RC", source = "RC")
    ReunionType reunionTypeDtoToReunionTypeModel(com.sncf.meetingplanner.ReunionType reunionType);
}
