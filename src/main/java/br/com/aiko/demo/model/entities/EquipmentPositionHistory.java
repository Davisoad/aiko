package br.com.aiko.demo.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "equipment_position_history", schema = "operation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "equipmentPositionHistoryId")
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
}