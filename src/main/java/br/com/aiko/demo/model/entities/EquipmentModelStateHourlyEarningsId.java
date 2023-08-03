package br.com.aiko.demo.model.entities;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class EquipmentModelStateHourlyEarningsId implements Serializable {

    private UUID equipment_model_id;
    private UUID equipment_state_id;

    public EquipmentModelStateHourlyEarningsId() {
    }

    public EquipmentModelStateHourlyEarningsId(UUID equipment_model_id, UUID equipment_state_id) {
        this.equipment_model_id = equipment_model_id;
        this.equipment_state_id = equipment_state_id;
    }

    public UUID getEquipment_model_id() {
        return equipment_model_id;
    }

    public void setEquipment_model_id(UUID equipment_model_id) {
        this.equipment_model_id = equipment_model_id;
    }

    public UUID getEquipment_state_id() {
        return equipment_state_id;
    }

    public void setEquipment_state_id(UUID equipment_state_id) {
        this.equipment_state_id = equipment_state_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EquipmentModelStateHourlyEarningsId that = (EquipmentModelStateHourlyEarningsId) o;
        return equipment_model_id.equals(that.equipment_model_id) && equipment_state_id.equals(that.equipment_state_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(equipment_model_id, equipment_state_id);
    }
}
