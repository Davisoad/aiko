package br.com.aiko.demo.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;


@Entity
@Table(name = "equipment_model_state_hourly_earnings", schema = "operation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "equipmentModelStateHourlyEarningsId")
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
}
