package br.com.aiko.demo.model.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "equipment_state_history", schema = "operation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "equipmentStateHistoryId")
public class EquipmentStateHistory {

    @EmbeddedId
    private EquipmentStateHistoryId equipmentStateHistoryId;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "equipment_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Equipment equipment;
    @Column(name = "date", insertable = false, updatable = false)
    private LocalDateTime date;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "equipment_state_id", referencedColumnName = "id", insertable = false, updatable = false)
    private EquipmentState equipmentState;
}

