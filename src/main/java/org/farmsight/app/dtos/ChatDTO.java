package org.farmsight.app.dtos;

import jakarta.validation.constraints.NotBlank;

public record ChatDTO (@NotBlank String message) {
}
