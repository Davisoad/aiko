package br.com.aiko.demo.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "equipment_model", schema = "operation")
public class EquipmentModel {

    @Id
    @GeneratedValue
    private UUID id;
    @Column(columnDefinition = "text")
    private String name;
    @OneToMany(mappedBy = "equipmentModel")
    @JsonIgnore
    private List<Equipment> equipments;
    @OneToMany(mappedBy = "equipmentModel")
    @JsonIgnore
    private List<EquipmentModelStateHourlyEarnings> equipmentModelStateHourlyEarnings;

    public EquipmentModel() {
    }

    public EquipmentModel(String name, List<Equipment> equipments, List<EquipmentModelStateHourlyEarnings> equipmentModelStateHourlyEarnings) {
        this.name = name;
        this.equipments = equipments;
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

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }

    public List<EquipmentModelStateHourlyEarnings> getEquipmentModelStateHourlyEarnings() {
        return equipmentModelStateHourlyEarnings;
    }

    public void setEquipmentModelStateHourlyEarnings(List<EquipmentModelStateHourlyEarnings> equipmentModelStateHourlyEarnings) {
        this.equipmentModelStateHourlyEarnings = equipmentModelStateHourlyEarnings;
    }
}
