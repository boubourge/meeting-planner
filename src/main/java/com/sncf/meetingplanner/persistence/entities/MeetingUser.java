package com.sncf.meetingplanner.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Table(name="meetinguser")
@Getter
@Setter
@AllArgsConstructor
public class MeetingUser {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String username;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String phone;

    private String userStatus;
}
