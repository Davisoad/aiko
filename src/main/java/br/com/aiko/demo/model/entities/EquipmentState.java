package br.com.aiko.demo.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "equipment_state", schema = "operation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class EquipmentState {

    @Id
    @GeneratedValue
    private UUID id;
    @Column(columnDefinition = "text")
    private String name;
    @Column(columnDefinition = "text")
    private String color;
    @OneToMany(mappedBy = "equipmentState")
    @JsonIgnore
    private List<EquipmentStateHistory> equipmentStateHistories;
    @OneToMany(mappedBy = "equipmentState")
    @JsonIgnore
    private List<EquipmentModelStateHourlyEarnings> equipmentModelStateHourlyEarnings;
}
