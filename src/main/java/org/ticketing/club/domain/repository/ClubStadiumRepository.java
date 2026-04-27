package org.ticketing.club.domain.repository;

import org.ticketing.club.domain.model.entity.ClubStadium;

import java.util.UUID;

public interface ClubStadiumRepository {

    ClubStadium save(ClubStadium clubStadium);

    boolean existsByClubIdAndStadiumId(UUID clubId, UUID stadiumId);
}
