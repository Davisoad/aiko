package br.com.aiko.demo.model.repositories;

import br.com.aiko.demo.model.entities.Equipment;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EquipmentRepository extends PagingAndSortingRepository<Equipment, UUID> {

}
