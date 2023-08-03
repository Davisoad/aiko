package br.com.aiko.demo.controllers;

import br.com.aiko.demo.model.entities.Equipment;
import br.com.aiko.demo.model.entities.EquipmentModel;
import br.com.aiko.demo.model.repositories.EquipmentModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/equipment-model")
public class EquipmentModelController {

    @Autowired
    private EquipmentModelRepository equipmentModelRepository;

    @GetMapping
    public Iterable<EquipmentModel> obterEquipmentModels() { return equipmentModelRepository.findAll(); }

    @PostMapping
    public ResponseEntity<EquipmentModel> salvarEquipmentModel(@Valid @RequestBody EquipmentModel equipmentModel) { return ResponseEntity.ok(equipmentModelRepository.save(equipmentModel)); }

    @PutMapping(path = "{id}")
    public ResponseEntity<EquipmentModel> atualizarEquipmentModel(@PathVariable("id") UUID id, @Valid @RequestBody EquipmentModel equipmentModelAtualizar) {

        EquipmentModel equipmentModel = equipmentModelRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Equipamento Model não encontrado"));

        equipmentModel.setName(equipmentModelAtualizar.getName());

        return ResponseEntity.ok(equipmentModelRepository.save(equipmentModel));
    }

    @GetMapping(path = "/{id}")
    public Optional<EquipmentModel> obterEquipmentModelPorId(@PathVariable UUID id) {
        return equipmentModelRepository.findById(id);
    }

    @DeleteMapping(path = "/{id}")
    public void deletarEquipmentModel(@PathVariable UUID id) {
        equipmentModelRepository.deleteById(id);
    }
}
