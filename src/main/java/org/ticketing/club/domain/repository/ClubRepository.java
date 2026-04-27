package org.ticketing.club.domain.repository;

import org.ticketing.club.domain.model.entity.Club;

import java.util.Optional;
import java.util.UUID;

public interface ClubRepository {

    Club save(Club club);

    boolean existsByClubName(String clubName);

    Optional<Club> findById(UUID id);
}
