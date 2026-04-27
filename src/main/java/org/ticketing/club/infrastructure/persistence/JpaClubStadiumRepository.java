package org.ticketing.club.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ticketing.club.domain.model.entity.ClubStadium;

import java.util.UUID;

public interface JpaClubStadiumRepository extends JpaRepository<ClubStadium, UUID> {

    boolean existsByClubIdAndStadiumIdAndDeletedAtIsNull(UUID clubId, UUID stadiumId);
}
