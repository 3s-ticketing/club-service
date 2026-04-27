package org.ticketing.club.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ticketing.club.domain.model.entity.ClubStadium;

import java.util.List;
import java.util.UUID;

public interface JpaClubStadiumRepository extends JpaRepository<ClubStadium, UUID> {

    boolean existsByClubIdAndStadiumIdAndDeletedAtIsNull(UUID clubId, UUID stadiumId);

    List<ClubStadium> findAllByClubIdAndDeletedAtIsNull(UUID clubId);
}
