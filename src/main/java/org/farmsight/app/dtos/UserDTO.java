package org.farmsight.app.dtos;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.farmsight.app.domain.Type;

public record UserDTO(
        @Size(min = 1, max = 255)
        String firstName,
        @Size(min = 1, max = 255)
        String lastName,
        @Email
        String email,
        @Enumerated(EnumType.STRING)
        @NotBlank
        Type type,
        @NotBlank
        String password
) {}
