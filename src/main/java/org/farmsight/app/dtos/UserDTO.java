package org.farmsight.app.dtos;

import org.farmsight.app.domain.Type;

public record UserDTO(
        String name,
        String email,
        Type type
) {}
