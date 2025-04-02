package com.sncf.meetingplanner.config;

import com.sncf.meetingplanner.model.mappers.ReunionMapper;
import com.sncf.meetingplanner.model.mappers.ReunionMapperImpl;
import com.sncf.meetingplanner.model.mappers.RoomMapper;
import com.sncf.meetingplanner.model.mappers.RoomMapperImpl;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.sncf.meetingplanner.persistence")
@EntityScan("com.sncf.meetingplanner.persistence.entities")
@ComponentScan("com.sncf.meetingplanner.service")
public class ApplicationConfiguration {

    @Bean
    public RoomMapper roomMapper() {
        return new RoomMapperImpl();
    }

    @Bean
    public ReunionMapper reunionMapper() {
        return new ReunionMapperImpl();
    }

}
