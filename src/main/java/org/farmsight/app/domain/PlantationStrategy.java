package org.farmsight.app.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder
@Getter
@Setter
@Entity
public class PlantationStrategy {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String strategyName;
    private String description;
}
