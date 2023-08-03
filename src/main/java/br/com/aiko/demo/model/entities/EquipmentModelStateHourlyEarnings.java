package br.com.aiko.demo.model.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "equipment_model_state_hourly_earnings", schema = "operation")
public class EquipmentModelStateHourlyEarnings {

    @EmbeddedId
    private EquipmentModelStateHourlyEarningsId equipmentModelStateHourlyEarningsId;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "equipment_model_id", referencedColumnName = "id", insertable = false, updatable = false)
    private EquipmentModel equipmentModel;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "equipment_state_id", referencedColumnName = "id", insertable = false, updatable = false)
    private EquipmentState equipmentState;
    @Column(columnDefinition = "real")
    private Double value;

    public EquipmentModelStateHourlyEarnings() {
    }

    public EquipmentModelStateHourlyEarnings(EquipmentModelStateHourlyEarningsId equipmentModelStateHourlyEarningsId, EquipmentModel equipmentModel, EquipmentState equipmentState, Double value) {
        this.equipmentModelStateHourlyEarningsId = equipmentModelStateHourlyEarningsId;
        this.equipmentModel = equipmentModel;
        this.equipmentState = equipmentState;
        this.value = value;
    }

    public EquipmentModelStateHourlyEarningsId getEquipmentModelStateHourlyEarningsId() {
        return equipmentModelStateHourlyEarningsId;
    }

    public void setEquipmentModelStateHourlyEarningsId(EquipmentModelStateHourlyEarningsId equipmentModelStateHourlyEarningsId) {
        this.equipmentModelStateHourlyEarningsId = equipmentModelStateHourlyEarningsId;
    }

    public EquipmentModel getEquipmentModel() {
        return equipmentModel;
    }

    public void setEquipmentModel(EquipmentModel equipmentModel) {
        this.equipmentModel = equipmentModel;
    }

    public EquipmentState getEquipmentState() {
        return equipmentState;
    }

    public void setEquipmentState(EquipmentState equipmentState) {
        this.equipmentState = equipmentState;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EquipmentModelStateHourlyEarnings that = (EquipmentModelStateHourlyEarnings) o;
        return equipmentModelStateHourlyEarningsId.equals(that.equipmentModelStateHourlyEarningsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(equipmentModelStateHourlyEarningsId);
    }
}
