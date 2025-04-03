package com.sncf.meetingplanner.model;

import com.sncf.meetingplanner.persistence.entities.enums.ReunionType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    private Integer id;
    private OffsetDateTime reservationDate;
    private ReunionType type;
    private String roomName;
    private String userName;
    private Integer participantNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OffsetDateTime getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(OffsetDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }

    public ReunionType getType() {
        return type;
    }

    public void setType(ReunionType type) {
        this.type = type;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getParticipantNumber() {
        return participantNumber;
    }

    public void setParticipantNumber(Integer participantNumber) {
        this.participantNumber = participantNumber;
    }
}
