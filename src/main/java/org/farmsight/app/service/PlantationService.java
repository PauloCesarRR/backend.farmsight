package org.farmsight.app.service;

import org.farmsight.app.domain.Farm;
import org.farmsight.app.domain.Plantation;
import org.farmsight.app.domain.Strategy;
import org.farmsight.app.repository.PlantationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class PlantationService {
    @Autowired
    private PlantationRepository repository;

    @Autowired
    private FarmService farmService;

    @Autowired
    private StrategyService strategyService;

    public Plantation create(Plantation plantation) {
        return repository.save(plantation);
    }

    public Plantation findById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


    public List<Plantation> findAll() {
        return repository.findAll();
    }

    public List<Plantation> findAllByFarm(UUID farmId) {
        Farm farm = farmService.findById(farmId);
        return repository.findAllByFarm(farm);
    }

    public List<Plantation> findAllByStrategy(UUID strategyId) {
        Strategy strategy = strategyService.findById(strategyId);
        return repository.findAllByStrategy(strategy);
    }
}
