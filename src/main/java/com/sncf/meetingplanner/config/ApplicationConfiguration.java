package com.sncf.meetingplanner.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.sncf.meetingplanner.persistence")
@EntityScan("com.sncf.meetingplanner.persistence.entities")
@ComponentScan("com.sncf.meetingplanner.service")
public class ApplicationConfiguration {

}
