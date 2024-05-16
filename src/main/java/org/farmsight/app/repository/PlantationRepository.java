package org.farmsight.app.repository;

import org.farmsight.app.domain.Farm;
import org.farmsight.app.domain.Plantation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PlantationRepository extends JpaRepository<Plantation, UUID> {
    List<Plantation> findAllByFarm(Farm farm);
}
