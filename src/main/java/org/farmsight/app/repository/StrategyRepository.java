package org.farmsight.app.repository;

import org.farmsight.app.domain.Strategy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StrategyRepository extends JpaRepository<Strategy, UUID> {
}
