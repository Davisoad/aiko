package br.com.aiko.demo.controllers;

import br.com.aiko.demo.model.entities.Equipment;
import br.com.aiko.demo.model.repositories.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

    import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentRepository equipmentRepository;

    @GetMapping
    public Iterable<Equipment> obterEquipments() {
        return equipmentRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Equipment> salvarEquipment(@Valid @RequestBody Equipment equipment) {
        return ResponseEntity.ok(equipmentRepository.save(equipment));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipment> atualizarEquipment(@PathVariable("id") UUID equipment_id,
                                                    @Valid @RequestBody Equipment equipmentAtualizado) {

        Equipment equipment = equipmentRepository.findById(equipment_id)
                .orElseThrow(() -> new IllegalArgumentException("Equipamento não encontrado"));

        equipment.setName(equipmentAtualizado.getName());
        equipment.setEquipment_model_id(equipmentAtualizado.getEquipment_model_id());

        return ResponseEntity.ok(equipmentRepository.save(equipment));
    }

    @GetMapping(path = "/{id}")
    public Optional<Equipment> obterEquipmentPorId(@PathVariable UUID id) {
        return equipmentRepository.findById(id);
    }

    @DeleteMapping(path = "/{id}")
    public void deletarEquipment(@PathVariable UUID id) {
        equipmentRepository.deleteById(id);
    }
}
