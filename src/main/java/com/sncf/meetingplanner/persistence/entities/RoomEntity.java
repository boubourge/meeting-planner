package com.sncf.meetingplanner.persistence.entities;

import com.sncf.meetingplanner.persistence.entities.enums.MaterialType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name="room")
public class RoomEntity  {

    @Id
    private String name;
    private Integer capacity;
    private List<MaterialType> material;

    public RoomEntity() {
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
