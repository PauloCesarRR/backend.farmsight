package org.farmsight.app.service;

import lombok.AllArgsConstructor;
import org.farmsight.app.domain.User;
import org.farmsight.app.dtos.UserDTO;
import org.farmsight.app.infra.exceptions.UserAlreadyExistsException;
import org.farmsight.app.infra.exceptions.UserNotFoundException;
import org.farmsight.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User create(UserDTO dto) {

        boolean userExists = repository.findByEmail(dto.email()).isPresent();
        if (userExists) {
            throw new UserAlreadyExistsException("Email already exists");
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(dto.password());
        User user = User.builder()
                .firstName(dto.firstName())
                .lastName(dto.lastName())
                .email(dto.email())
                .password(encryptedPassword)
                .type(dto.type())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .deletedAt(null)
                .build();

        return repository.save(user);
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new UserNotFoundException("User Not Found"));
    }

    public User findByEmail(String email) {
        return repository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User Not Found"));
    }


}
