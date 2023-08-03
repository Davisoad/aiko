package br.com.aiko.demo.model.repositories;

import br.com.aiko.demo.model.entities.EquipmentState;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EquipmentStateRepository extends PagingAndSortingRepository<EquipmentState, UUID> {
}
