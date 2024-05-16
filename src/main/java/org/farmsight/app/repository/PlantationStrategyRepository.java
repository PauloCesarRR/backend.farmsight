package org.farmsight.app.repository;

import org.farmsight.app.domain.PlantationStrategy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlantationStrategyRepository extends JpaRepository<PlantationStrategy, UUID> {
}
