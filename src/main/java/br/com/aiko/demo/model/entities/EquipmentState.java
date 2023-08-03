package br.com.aiko.demo.model.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "equipment_state", schema = "operation")
public class EquipmentState {

    @Id
    @GeneratedValue
    private UUID id;
    @Column(columnDefinition = "text")
    private String name;
    @Column(columnDefinition = "text")
    private String color;
    @OneToMany(mappedBy = "equipmentState")
    @JsonIgnore
    private List<EquipmentStateHistory> equipmentStateHistories;
    @OneToMany(mappedBy = "equipmentState")
    @JsonIgnore
    private List<EquipmentModelStateHourlyEarnings> equipmentModelStateHourlyEarnings;

    public EquipmentState() {
    }

    public EquipmentState(String name, String color, List<EquipmentStateHistory> equipmentStateHistories, List<EquipmentModelStateHourlyEarnings> equipmentModelStateHourlyEarnings) {
        this.name = name;
        this.color = color;
        this.equipmentStateHistories = equipmentStateHistories;
        this.equipmentModelStateHourlyEarnings = equipmentModelStateHourlyEarnings;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<EquipmentStateHistory> getEquipmentStateHistories() {
        return equipmentStateHistories;
    }

    public void setEquipmentStateHistories(List<EquipmentStateHistory> equipmentStateHistories) {
        this.equipmentStateHistories = equipmentStateHistories;
    }

    public List<EquipmentModelStateHourlyEarnings> getEquipmentModelStateHourlyEarnings() {
        return equipmentModelStateHourlyEarnings;
    }

    public void setEquipmentModelStateHourlyEarnings(List<EquipmentModelStateHourlyEarnings> equipmentModelStateHourlyEarnings) {
        this.equipmentModelStateHourlyEarnings = equipmentModelStateHourlyEarnings;
    }
}
