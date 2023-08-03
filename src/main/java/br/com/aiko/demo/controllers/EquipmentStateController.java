package br.com.aiko.demo.controllers;

import br.com.aiko.demo.model.entities.Equipment;
import br.com.aiko.demo.model.entities.EquipmentState;
import br.com.aiko.demo.model.repositories.EquipmentStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/equipment-state")
public class EquipmentStateController {

    @Autowired
    private EquipmentStateRepository equipmentStateRepository;

    @GetMapping
    public Iterable<EquipmentState> obterEquipmentStates() {
        return equipmentStateRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<EquipmentState> salvarEquipmentState(@Valid @RequestBody EquipmentState equipmentState) {
        return ResponseEntity.ok(equipmentStateRepository.save(equipmentState));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EquipmentState> atualizarEquipmentState(@PathVariable("id") UUID id,
                                                        @Valid @RequestBody EquipmentState equipmentStateAtualizado) {

        EquipmentState equipmentState = equipmentStateRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Equipment State não encontrado"));

        equipmentState.setName(equipmentStateAtualizado.getName());
        equipmentState.setColor(equipmentStateAtualizado.getColor());

        return ResponseEntity.ok(equipmentStateRepository.save(equipmentState));
    }

    @GetMapping(path = "/{id}")
    public Optional<EquipmentState> obterEquipmentStatePorId(@PathVariable UUID id) {
        return equipmentStateRepository.findById(id);
    }

    @DeleteMapping(path = "/{id}")
    public void deletarEquipmentState(@PathVariable UUID id) {
        equipmentStateRepository.deleteById(id);
    }
}
