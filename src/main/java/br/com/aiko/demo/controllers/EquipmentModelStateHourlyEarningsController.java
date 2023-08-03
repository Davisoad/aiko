package br.com.aiko.demo.controllers;

import br.com.aiko.demo.model.entities.EquipmentModelStateHourlyEarnings;
import br.com.aiko.demo.model.repositories.EquipmentModelStateHourlyEarningsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/equipment-model-state-hourly-earnings")
public class EquipmentModelStateHourlyEarningsController {

    @Autowired
    private EquipmentModelStateHourlyEarningsRepository equipmentModelStateHourlyEarningsRepository;

    @GetMapping
    public Iterable<EquipmentModelStateHourlyEarnings> obterEquipmentModelStateHourlyEarnings() { return equipmentModelStateHourlyEarningsRepository.findAll(); }
}
