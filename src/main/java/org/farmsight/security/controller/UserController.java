package org.farmsight.security.controller;

import lombok.AllArgsConstructor;
import org.farmsight.security.domain.User;
import org.farmsight.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController("/user")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private final UserService service;

    @PostMapping
    public ResponseEntity<URI> create(@RequestBody User user) {
        service.create(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }

}
