package org.farmsight.app.controller;

import org.farmsight.app.domain.Farm;
import org.farmsight.app.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/farm")
public class FarmController {

    @Autowired
    private FarmService service;

    @PostMapping
    public ResponseEntity<Farm> create(@RequestBody Farm farm) {
        return ResponseEntity.ok(service.create(farm));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Farm> findById(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(UUID.fromString(id)));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Farm>> findAllByUser(@PathVariable String userId) {
        return ResponseEntity.ok(service.findAllByUser(UUID.fromString(userId)));
    }

}
