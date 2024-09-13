package org.farmsight.app.service;

import org.farmsight.app.domain.Farm;
import org.farmsight.app.domain.Strategy;
import org.farmsight.app.infra.exceptions.StrategyNotFoundException;
import org.farmsight.app.repository.StrategyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class StrategyService {

    @Autowired
    private StrategyRepository repository;

    public Strategy create(Strategy strategy) {
        return repository.save(strategy);
    }

    public Strategy findById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new StrategyNotFoundException("Strategy Not Found"));
    }

    public List<Strategy> findAll() {
        return repository.findAll();
    }
}
