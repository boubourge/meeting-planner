package com.sncf.meetingplanner.persistence.entities;

import com.sncf.meetingplanner.persistence.entities.enums.ReunionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="reservation")
@Getter
@Setter
@AllArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private LocalDateTime reservationDate;
    private ReunionType type;
    private String roomName;
    private String userName;
}
