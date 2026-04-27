package org.ticketing.club.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ticketing.club.domain.model.entity.Club;

import java.util.Optional;
import java.util.UUID;

public interface JpaClubRepository extends JpaRepository<Club, UUID> {

    boolean existsByClubNameAndDeletedAtIsNull(String clubName);

    Optional<Club> findByIdAndDeletedAtIsNull(UUID id);

    boolean existsByIdAndDeletedAtIsNull(UUID id);
}
