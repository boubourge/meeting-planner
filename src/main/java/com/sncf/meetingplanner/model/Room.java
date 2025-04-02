package com.sncf.meetingplanner.model;

import com.sncf.meetingplanner.model.enums.MaterialType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class Room {

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
