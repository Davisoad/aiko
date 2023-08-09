package br.com.aiko.demo.model.repositories;

import br.com.aiko.demo.model.entities.EquipmentPositionHistory;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface EquipmentPositionHistoryRepository extends PagingAndSortingRepository<EquipmentPositionHistory, UUID> {
    List<EquipmentPositionHistory> findByEquipmentPositionHistoryIdEquipmentIdAndEquipmentPositionHistoryIdDate(UUID equipmentId, LocalDateTime date);
}
