package br.com.aiko.demo.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "equipment_position_history", schema = "operation")
public class EquipmentPositionHistory {

    @EmbeddedId
    private EquipmentPositionHistoryId equipmentPositionHistoryId;
    @Column(columnDefinition = "timestamp", insertable = false, updatable = false)
    private LocalDateTime date;
    @Column(columnDefinition = "real")
    private Double lat;
    @Column(columnDefinition = "real")
    private Double lon;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinColumn(name = "equipment_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Equipment equipment;
    public EquipmentPositionHistory() {
    }

    public EquipmentPositionHistory(EquipmentPositionHistoryId equipmentPositionHistoryId, LocalDateTime date, Double lat, Double lon, Equipment equipment) {
        this.equipmentPositionHistoryId = equipmentPositionHistoryId;
        this.date = date;
        this.lat = lat;
        this.lon = lon;
        this.equipment = equipment;
    }

    public EquipmentPositionHistoryId getEquipmentPositionHistoryId() {
        return equipmentPositionHistoryId;
    }

    public void setEquipmentPositionHistoryId(EquipmentPositionHistoryId equipmentPositionHistoryId) {
        this.equipmentPositionHistoryId = equipmentPositionHistoryId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = Math.round(lat * 1000000.0) / 1000000.0;;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = Math.round(lon * 1000000.0) / 1000000.0;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
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