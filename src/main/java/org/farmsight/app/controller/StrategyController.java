package org.farmsight.app.controller;

import org.farmsight.app.domain.Farm;
import org.farmsight.app.domain.Strategy;
import org.farmsight.app.service.FarmService;
import org.farmsight.app.service.StrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/strategy")
public class StrategyController {

    @Autowired
    private StrategyService service;

    @PostMapping
    public ResponseEntity<Strategy> create(@RequestBody Strategy strategy) {
        return ResponseEntity.ok(service.create(strategy));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Strategy> findById(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(UUID.fromString(id)));
    }

    @GetMapping
    public ResponseEntity<List<Strategy>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

}
