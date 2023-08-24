package br.com.aiko.demo.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "equipment", schema = "operation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
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
}
