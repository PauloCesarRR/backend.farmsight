package org.farmsight.app.repository;

import org.farmsight.app.domain.Farm;
import org.farmsight.app.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FarmRepository extends JpaRepository<Farm, UUID> {
    List<Farm> findAllByUser(User user);
}
