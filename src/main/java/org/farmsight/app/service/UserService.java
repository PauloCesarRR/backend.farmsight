package org.farmsight.app.service;

import lombok.AllArgsConstructor;
import org.farmsight.app.domain.User;
import org.farmsight.app.dtos.UserDTO;
import org.farmsight.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {

    private final UserRepository repository;

    public User create(UserDTO dto) {
        User user = User.builder()
                .username(dto.username())
                .email(dto.email())
                .type(dto.type())
                .build();

        if(repository.findById(user.getId()).isPresent()){
            throw new DataIntegrityViolationException("Usuário já cadastrado");
        }


        return repository.save(user);
    }

    public User findById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
