package com.sncf.meetingplanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class MeetingplannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeetingplannerApplication.class, args);
	}

}
