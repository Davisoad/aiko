package br.com.aiko.demo.controllers;

import br.com.aiko.demo.model.entities.*;
import br.com.aiko.demo.model.repositories.EquipmentRepository;
import br.com.aiko.demo.model.repositories.EquipmentStateHistoryRepository;
import br.com.aiko.demo.model.repositories.EquipmentStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/equipment-state-history")
public class EquipmentStateHistoryController {

    @Autowired
    private EquipmentStateHistoryRepository equipmentStateHistoryRepository;

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Autowired
    private EquipmentStateRepository equipmentStateRepository;

    @GetMapping
    public Iterable<EquipmentStateHistory> obterEquipmentStateHistorys() {return equipmentStateHistoryRepository.findAll(); }

    @PostMapping
    public ResponseEntity<EquipmentStateHistory> salvarEquipmentStateHistory(@Valid @RequestBody EquipmentStateHistory equipmentStateHistory) {
        UUID equipment_id = equipmentStateHistory.getEquipmentStateHistoryId().getEquipmentId();
        LocalDateTime date = equipmentStateHistory.getDate();
        UUID equipment_state_id = equipmentStateHistory.getEquipmentStateHistoryId().getEquipmentStateId();

        Equipment existingEquipment = equipmentRepository.findById(equipment_id).orElse(null);
        EquipmentState existingEquipmentState = equipmentStateRepository.findById(equipment_state_id).orElse(null);

        if (existingEquipment == null || existingEquipmentState == null) {
            return ResponseEntity.notFound().build();
        }

        EquipmentStateHistoryId newId = new EquipmentStateHistoryId(equipment_id, equipment_state_id, date);

        equipmentStateHistory.setEquipmentStateHistoryId(newId);

        return ResponseEntity.ok(equipmentStateHistoryRepository.save(equipmentStateHistory));
    }

    @GetMapping(path = "/{id}")
    public List<EquipmentStateHistory> obterEquipmentStateHistoryPorIdDate(@PathVariable UUID id, @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date, @RequestParam("id") UUID equipment_state_id) {
        return equipmentStateHistoryRepository
                .findByEquipmentStateHistoryIdEquipmentIdAndEquipmentStateHistoryIdEquipmentStateIdAndDate(
                        id,
                        equipment_state_id,
                        date
                );
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deletarEquipmentStateHistory(@PathVariable("id") UUID equipmentId, @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date, @RequestParam("id") UUID equipment_state_id) {
        List<EquipmentStateHistory> resultList = equipmentStateHistoryRepository
                .findByEquipmentStateHistoryIdEquipmentIdAndEquipmentStateHistoryIdEquipmentStateIdAndDate(
                        equipmentId,
                        equipment_state_id,
                        date
                );

        if (resultList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        EquipmentStateHistory equipmentStateHistory = resultList.get(0);
        equipmentStateHistoryRepository.delete(equipmentStateHistory);

        return ResponseEntity.ok("Registro excluído com sucesso");
    }
}
