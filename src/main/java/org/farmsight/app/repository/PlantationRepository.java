package org.farmsight.app.repository;

import org.farmsight.app.domain.Plantation;
import org.farmsight.app.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlantationRepository extends JpaRepository<Plantation, UUID> {
}
