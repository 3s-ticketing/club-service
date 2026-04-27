package org.ticketing.club.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.ticketing.club.domain.model.entity.Club;

import java.util.Optional;
import java.util.UUID;

public interface ClubRepository {

    Club save(Club club);

    boolean existsByClubName(String clubName);

    Optional<Club> findById(UUID id);

    boolean existsById(UUID id);

    Page<Club> findAll(String keyword, Pageable pageable);
}
