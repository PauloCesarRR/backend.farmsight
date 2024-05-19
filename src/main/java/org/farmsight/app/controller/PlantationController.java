package org.farmsight.app.controller;

import org.farmsight.app.domain.Farm;
import org.farmsight.app.domain.Plantation;
import org.farmsight.app.service.FarmService;
import org.farmsight.app.service.PlantationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/plantation")
public class PlantationController {

    @Autowired
    private PlantationService service;

    @PostMapping
    public ResponseEntity<Plantation> create(@RequestBody Plantation plantation) {
        return ResponseEntity.ok(service.create(plantation));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plantation> findById(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(UUID.fromString(id)));
    }

    @GetMapping
    public ResponseEntity<List<Plantation>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/farm/{farmId}")
    public ResponseEntity<List<Plantation>> findAllByFarm(@PathVariable String farmId) {
        return ResponseEntity.ok(service.findAllByFarm(UUID.fromString(farmId)));
    }

    @GetMapping("/strategy/{strategyId}")
    public ResponseEntity<List<Plantation>> findAllByStrategy(@PathVariable String strategyId) {
        return ResponseEntity.ok(service.findAllByStrategy(UUID.fromString(strategyId)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePlantationById(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
