package com.sncf.meetingplanner.persistence.entities;

import com.sncf.meetingplanner.persistence.entities.enums.ReunionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Entity
@Table(name = "reservation")
@Getter
@Setter
@AllArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private OffsetDateTime reservationDate;

    @Enumerated(EnumType.STRING)
    private ReunionType type;

    private String roomName;

    private String userName;

    private Integer participantNumber;
}
