package com.sncf.meetingplanner.persistence.entities;

import com.sncf.meetingplanner.persistence.entities.enums.MaterialType;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "room")
public class Room {

    @Id
    private String name;

    private Integer capacity;

    @Enumerated(EnumType.STRING)
    private List<MaterialType> material;

    public Room() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public List<MaterialType> getMaterial() {
        return material;
    }

    public void setMaterial(List<MaterialType> material) {
        this.material = material;
    }
}
