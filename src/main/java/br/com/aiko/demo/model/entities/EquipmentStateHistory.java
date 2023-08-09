package br.com.aiko.demo.model.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "equipment_state_history", schema = "operation")
public class EquipmentStateHistory {

    @EmbeddedId
    private EquipmentStateHistoryId equipmentStateHistoryId;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "equipment_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Equipment equipment;
    @Column(name = "date", insertable = false, updatable = false)
    private LocalDateTime date;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "equipment_state_id", referencedColumnName = "id", insertable = false, updatable = false)
    private EquipmentState equipmentState;

    public EquipmentStateHistory() {
    }

    public EquipmentStateHistory(EquipmentStateHistoryId equipmentStateHistoryId, Equipment equipment, LocalDateTime date, EquipmentState equipmentState) {
        this.equipmentStateHistoryId = equipmentStateHistoryId;
        this.equipment = equipment;
        this.date = date;
        this.equipmentState = equipmentState;
    }

    public EquipmentStateHistoryId getEquipmentStateHistoryId() {
        return equipmentStateHistoryId;
    }

    public void setEquipmentStateHistoryId(EquipmentStateHistoryId equipmentStateHistoryId) {
        this.equipmentStateHistoryId = equipmentStateHistoryId;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public EquipmentState getEquipmentState() {
        return equipmentState;
    }

    public void setEquipmentState(EquipmentState equipmentState) {
        this.equipmentState = equipmentState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EquipmentStateHistory that = (EquipmentStateHistory) o;
        return Objects.equals(equipmentStateHistoryId, that.equipmentStateHistoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(equipmentStateHistoryId);
    }
}

