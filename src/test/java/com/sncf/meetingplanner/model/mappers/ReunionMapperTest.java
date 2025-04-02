package com.sncf.meetingplanner.model.mappers;

import com.sncf.meetingplanner.ReunionType;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReunionMapperTest {

    @ParameterizedTest
    @EnumSource(ReunionType.class)
    void reunionTypeDtoToReunionTypeModelTest(ReunionType reunionType) {

        // Given
        ReunionMapper reunionMapper = new ReunionMapperImpl();

        // When
        var result = reunionMapper.reunionTypeDtoToReunionTypeModel(reunionType);

        // Then
        assertEquals(switch (reunionType) {
            case RS -> com.sncf.meetingplanner.model.enums.ReunionType.RS;
            case SPEC -> com.sncf.meetingplanner.model.enums.ReunionType.SPEC;
            case VC -> com.sncf.meetingplanner.model.enums.ReunionType.VC;
            case RC -> com.sncf.meetingplanner.model.enums.ReunionType.RC;
        }, result);
    }
}
