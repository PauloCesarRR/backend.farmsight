package org.farmsight.security.service;

import lombok.AllArgsConstructor;
import org.farmsight.security.domain.User;
import org.farmsight.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {

    private final UserRepository repository;

    public void create(User user) {
        repository.save(user);
    }

    public User getById(UUID id) throws ChangeSetPersister.NotFoundException {
        return repository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

}
