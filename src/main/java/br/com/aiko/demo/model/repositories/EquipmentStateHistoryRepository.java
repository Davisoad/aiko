package br.com.aiko.demo.model.repositories;

import br.com.aiko.demo.model.entities.EquipmentStateHistory;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface EquipmentStateHistoryRepository extends PagingAndSortingRepository<EquipmentStateHistory, UUID> {
    List<EquipmentStateHistory> findByEquipmentStateHistoryIdEquipmentIdAndEquipmentStateHistoryIdEquipmentStateIdAndDate(UUID equipmentId, UUID equipmentStateId, LocalDateTime date);
}
