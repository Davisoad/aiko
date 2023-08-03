package br.com.aiko.demo.model.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "equipment_position_history", schema = "operation")
public class EquipmentPositionHistory {

    @EmbeddedId
    private EquipmentPositionHistoryId equipmentPositionHistoryId;
    @Column(columnDefinition = "timestamp", insertable = false, updatable = false)
    private Timestamp date;
    @Column(columnDefinition = "real")
    private Double lat;
    @Column(columnDefinition = "real")
    private Double lon;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "equipment_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Equipment equipment;
    public EquipmentPositionHistory() {
    }

    public EquipmentPositionHistory(EquipmentPositionHistoryId equipmentPositionHistoryId, Timestamp date, Double lat, Double lon, Equipment equipment) {
        this.equipmentPositionHistoryId = equipmentPositionHistoryId;
        this.date = date;
        this.lat = lat;
        this.lon = lon;
        this.equipment = equipment;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public EquipmentPositionHistoryId getEquipmentPositionHistoryId() {
        return equipmentPositionHistoryId;
    }

    public void setEquipmentPositionHistoryId(EquipmentPositionHistoryId equipmentPositionHistoryId) {
        this.equipmentPositionHistoryId = equipmentPositionHistoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EquipmentPositionHistory that = (EquipmentPositionHistory) o;
        return Objects.equals(equipmentPositionHistoryId, that.equipmentPositionHistoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(equipmentPositionHistoryId);
    }
}