package br.com.aiko.demo.model.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class EquipmentModelStateHourlyEarningsId implements Serializable {

    @Column(name = "equipment_model_id")
    private UUID equipmentModelId;
    @Column(name = "equipment_state_id")
    private UUID equipmentStateId;

    public EquipmentModelStateHourlyEarningsId() {
    }

    public EquipmentModelStateHourlyEarningsId(UUID equipmentModelId, UUID equipmentStateId) {
        this.equipmentModelId = equipmentModelId;
        this.equipmentStateId = equipmentStateId;
    }

    public UUID getEquipmentModelId() {
        return equipmentModelId;
    }

    public void setEquipmentModelId(UUID equipmentModelId) {
        this.equipmentModelId = equipmentModelId;
    }

    public UUID getEquipmentStateId() {
        return equipmentStateId;
    }

    public void setEquipmentStateId(UUID equipmentStateId) {
        this.equipmentStateId = equipmentStateId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EquipmentModelStateHourlyEarningsId that = (EquipmentModelStateHourlyEarningsId) o;
        return Objects.equals(equipmentModelId, that.equipmentModelId) && Objects.equals(equipmentStateId, that.equipmentStateId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(equipmentModelId, equipmentStateId);
    }
}
