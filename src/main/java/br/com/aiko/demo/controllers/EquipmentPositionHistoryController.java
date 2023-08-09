package br.com.aiko.demo.controllers;

import br.com.aiko.demo.model.entities.Equipment;
import br.com.aiko.demo.model.entities.EquipmentPositionHistory;
import br.com.aiko.demo.model.entities.EquipmentPositionHistoryId;
import br.com.aiko.demo.model.repositories.EquipmentPositionHistoryRepository;
import br.com.aiko.demo.model.repositories.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/equipment-position-history")
public class EquipmentPositionHistoryController {

    @Autowired
    private EquipmentPositionHistoryRepository equipmentPositionHistoryRepository;

    @Autowired
    private EquipmentRepository equipmentRepository;

    @GetMapping
    public Iterable<EquipmentPositionHistory> obterEquipmentPositionHistorys() {return equipmentPositionHistoryRepository.findAll(); }

    @PostMapping
    public ResponseEntity<EquipmentPositionHistory> salvarEquipmentPositionHistory(@Valid @RequestBody EquipmentPositionHistory equipmentPositionHistory) {
        UUID equipmentId = equipmentPositionHistory.getEquipmentPositionHistoryId().getEquipmentId();
        LocalDateTime date = equipmentPositionHistory.getDate();

        Equipment existingEquipment = equipmentRepository.findById(equipmentId).orElse(null);
        if (existingEquipment == null) {
            return ResponseEntity.notFound().build();
        }

        EquipmentPositionHistoryId newId = new EquipmentPositionHistoryId(equipmentId, date);

        equipmentPositionHistory.setEquipmentPositionHistoryId(newId);

        return ResponseEntity.ok(equipmentPositionHistoryRepository.save(equipmentPositionHistory));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EquipmentPositionHistory> atualizarEquipmentPositionHistory(
            @PathVariable("id") UUID id,
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date,
            @Valid @RequestBody EquipmentPositionHistory equipmentPositionHistoryAtualizado) {

        List<EquipmentPositionHistory> resultList = equipmentPositionHistoryRepository.findByEquipmentPositionHistoryIdEquipmentIdAndEquipmentPositionHistoryIdDate(id, date);

        if (resultList.isEmpty()) {
            throw new IllegalArgumentException("Registro não encontrado");
        }

        EquipmentPositionHistory equipmentPositionHistory = resultList.get(0);

        equipmentPositionHistory.setLat(equipmentPositionHistoryAtualizado.getLat());
        equipmentPositionHistory.setLon(equipmentPositionHistoryAtualizado.getLon());

        return ResponseEntity.ok(equipmentPositionHistoryRepository.save(equipmentPositionHistory));
    }

    @GetMapping(path = "/{id}")
    public List<EquipmentPositionHistory> obterEquipmentPositionHistoryPorIdDate(@PathVariable UUID id, @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) {
        return equipmentPositionHistoryRepository.findByEquipmentPositionHistoryIdEquipmentIdAndEquipmentPositionHistoryIdDate(id, date);
    }

    @DeleteMapping(path = "/{equipment_id}")
    public ResponseEntity<String> deletarEquipment(@PathVariable("equipment_id") UUID equipmentId, @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) {
        List<EquipmentPositionHistory> resultList = equipmentPositionHistoryRepository.findByEquipmentPositionHistoryIdEquipmentIdAndEquipmentPositionHistoryIdDate(equipmentId, date);

        if (resultList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        EquipmentPositionHistory equipmentPositionHistory = resultList.get(0);
        equipmentPositionHistoryRepository.delete(equipmentPositionHistory);

        return ResponseEntity.ok("Registro excluído com sucesso");
    }
}
