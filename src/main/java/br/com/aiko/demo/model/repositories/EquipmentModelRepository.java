package br.com.aiko.demo.model.repositories;

import br.com.aiko.demo.model.entities.EquipmentModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EquipmentModelRepository extends PagingAndSortingRepository<EquipmentModel, UUID> {
}
