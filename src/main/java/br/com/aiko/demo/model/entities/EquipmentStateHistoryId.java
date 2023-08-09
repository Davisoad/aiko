package br.com.aiko.demo.model.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class EquipmentStateHistoryId implements Serializable {

    @Column(name = "equipment_id")
    private UUID equipmentId;
    @Column(name = "equipment_state_id")
    private UUID equipmentStateId;
    @Column(name = "date")
    private LocalDateTime date;

    public EquipmentStateHistoryId() {
    }

    public EquipmentStateHistoryId(UUID equipmentId, UUID equipmentStateId, LocalDateTime date) {
        this.equipmentId = equipmentId;
        this.equipmentStateId = equipmentStateId;
        this.date = date;
    }

    public UUID getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(UUID equipmentId) {
        this.equipmentId = equipmentId;
    }

    public UUID getEquipmentStateId() {
        return equipmentStateId;
    }

    public void setEquipmentStateId(UUID equipmentStateId) {
        this.equipmentStateId = equipmentStateId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EquipmentStateHistoryId that = (EquipmentStateHistoryId) o;
        return Objects.equals(equipmentId, that.equipmentId) && Objects.equals(equipmentStateId, that.equipmentStateId) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(equipmentId, equipmentStateId, date);
    }
}
