package org.ticketing.club.domain.repository;

import org.ticketing.club.domain.model.entity.Club;

public interface ClubRepository {

    Club save(Club club);

    boolean existsByClubName(String clubName);
}
