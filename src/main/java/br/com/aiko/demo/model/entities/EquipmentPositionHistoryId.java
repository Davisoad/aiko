package br.com.aiko.demo.model.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class EquipmentPositionHistoryId implements Serializable {

    @Column(name = "equipment_id")
    private UUID equipmentId;

    @Column(name = "date")
    private Timestamp date;

    public EquipmentPositionHistoryId() {
    }

    public EquipmentPositionHistoryId(UUID equipmentId, Timestamp date) {
        this.equipmentId = equipmentId;
        this.date = date;
    }

    public UUID getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(UUID equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EquipmentPositionHistoryId that = (EquipmentPositionHistoryId) o;
        return Objects.equals(equipmentId, that.equipmentId) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(equipmentId, date);
    }
}
