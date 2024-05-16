package org.farmsight.app.service;

import org.farmsight.app.domain.Farm;
import org.farmsight.app.domain.User;
import org.farmsight.app.repository.FarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class FarmService {
    @Autowired
    private FarmRepository repository;

    @Autowired
    private UserService userService;

    public Farm create(Farm farm) {
        return repository.save(farm);
    }

    public Farm findById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<Farm> findAllByUser(UUID userId) {
        User user = userService.findById(userId);
        return repository.findAllByUser(user);
    }


}
