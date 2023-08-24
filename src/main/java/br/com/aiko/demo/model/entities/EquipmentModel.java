package br.com.aiko.demo.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "equipment_model", schema = "operation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class EquipmentModel {

    @Id
    @GeneratedValue
    private UUID id;
    @Column(columnDefinition = "text")
    private String name;
    @OneToMany(mappedBy = "equipmentModel")
    @JsonIgnore
    private List<Equipment> equipments;
    @OneToMany(mappedBy = "equipmentModel")
    @JsonIgnore
    private List<EquipmentModelStateHourlyEarnings> equipmentModelStateHourlyEarnings;
}
