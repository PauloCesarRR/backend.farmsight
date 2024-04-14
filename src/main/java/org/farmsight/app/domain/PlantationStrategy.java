package org.farmsight.app.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@Entity(name = "tb_plantation_strategy")
@NoArgsConstructor
@AllArgsConstructor
public class PlantationStrategy {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String strategyName;
    private String description;
}
