package org.farmsight.app.service;

import org.farmsight.app.domain.Farm;
import org.farmsight.app.domain.Income;
import org.farmsight.app.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class IncomeService {
    @Autowired
    private IncomeRepository repository;

    @Autowired
    private FarmService farmService;

    public Income create(Income income) {
        return repository.save(income);
    }

    public Income findById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<Income> findAllByFarm(UUID farmId) {
        Farm farm = farmService.findById(farmId);
        return repository.findAllByFarm(farm);
    }


}