package org.ticketing.club.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ticketing.club.domain.model.entity.Stadium;

import java.util.Optional;
import java.util.UUID;

public interface JpaStadiumRepository extends JpaRepository<Stadium, UUID> {

    Optional<Stadium> findByIdAndDeletedAtIsNull(UUID id);

    boolean existsByIdAndDeletedAtIsNull(UUID id);

    boolean existsByNameAndDeletedAtIsNull(String name);
}
