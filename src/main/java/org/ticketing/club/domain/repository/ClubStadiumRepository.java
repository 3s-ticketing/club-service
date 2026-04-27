package org.ticketing.club.domain.repository;

import org.ticketing.club.domain.model.entity.ClubStadium;

import java.util.List;
import java.util.UUID;

public interface ClubStadiumRepository {

    ClubStadium save(ClubStadium clubStadium);

    boolean existsByClubIdAndStadiumId(UUID clubId, UUID stadiumId);

    List<ClubStadium> findAllByClubId(UUID clubId);
}
