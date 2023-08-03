package br.com.aiko.demo.model.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "equipment", schema = "operation")
public class Equipment {

    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "equipment_model_id", insertable = false, updatable = false)
    @JsonIgnore
    private EquipmentModel equipmentModel;
    @Column(columnDefinition = "text")
    private String name;

    @Column(name = "equipment_model_id")
    private UUID equipment_model_id;

    @OneToMany(mappedBy = "equipment", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<EquipmentPositionHistory> equipmentPositionHistories;

    @OneToMany(mappedBy = "equipment")
    @JsonIgnore
    private List<EquipmentStateHistory> equipmentStateHistories;

    public Equipment() {
    }

    public Equipment(EquipmentModel equipmentModel, String name, UUID equipment_model_id, List<EquipmentPositionHistory> equipmentPositionHistories, List<EquipmentStateHistory> equipmentStateHistories) {
        this.equipmentModel = equipmentModel;
        this.name = name;
        this.equipment_model_id = equipment_model_id;
        this.equipmentPositionHistories = equipmentPositionHistories;
        this.equipmentStateHistories = equipmentStateHistories;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public EquipmentModel getEquipmentModel() {
        return equipmentModel;
    }

    public void setEquipmentModel(EquipmentModel equipmentModel) {
        this.equipmentModel = equipmentModel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EquipmentPositionHistory> getEquipmentPositionHistories() {
        return equipmentPositionHistories;
    }

    public void setEquipmentPositionHistories(List<EquipmentPositionHistory> equipmentPositionHistories) {
        this.equipmentPositionHistories = equipmentPositionHistories;
    }

    public UUID getEquipmentModelId() {
        return equipment_model_id;
    }

    public void setEquipmentModelId(UUID equipmentModelId) {
        this.equipment_model_id = equipmentModelId;
    }

    public List<EquipmentStateHistory> getEquipmentStateHistories() {
        return equipmentStateHistories;
    }

    public void setEquipmentStateHistories(List<EquipmentStateHistory> equipmentStateHistories) {
        this.equipmentStateHistories = equipmentStateHistories;
    }
}
