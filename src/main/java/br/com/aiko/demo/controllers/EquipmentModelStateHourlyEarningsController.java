package br.com.aiko.demo.controllers;

import br.com.aiko.demo.model.entities.EquipmentModelStateHourlyEarnings;
import br.com.aiko.demo.model.entities.EquipmentPositionHistory;
import br.com.aiko.demo.model.repositories.EquipmentModelStateHourlyEarningsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/equipment-model-state-hourly-earnings")
public class EquipmentModelStateHourlyEarningsController {

    @Autowired
    private EquipmentModelStateHourlyEarningsRepository equipmentModelStateHourlyEarningsRepository;

    @GetMapping
    public Iterable<EquipmentModelStateHourlyEarnings> obterEquipmentModelStateHourlyEarnings() { return equipmentModelStateHourlyEarningsRepository.findAll(); }

    @GetMapping(path = "/{id}")
    public List<EquipmentModelStateHourlyEarnings> obterEquipmentModelStateHourlyEarningsId(@PathVariable UUID id, @RequestParam("id") UUID equipment_state_id) {
        return equipmentModelStateHourlyEarningsRepository.findByEquipmentModelStateHourlyEarningsIdEquipmentModelIdAndEquipmentModelStateHourlyEarningsIdEquipmentStateId(id, equipment_state_id);
    }
}
