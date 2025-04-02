package com.sncf.meetingplanner.model;

import com.sncf.meetingplanner.model.enums.MaterialType;
import com.sncf.meetingplanner.persistence.entities.enums.ReunionType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    private String name;
    private Integer capacity;
    private List<MaterialType> material;

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
