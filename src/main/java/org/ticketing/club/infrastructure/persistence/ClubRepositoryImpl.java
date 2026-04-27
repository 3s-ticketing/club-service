package org.ticketing.club.infrastructure.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.ticketing.club.domain.model.entity.Club;
import org.ticketing.club.domain.repository.ClubRepository;

@Repository
@RequiredArgsConstructor
public class ClubRepositoryImpl implements ClubRepository {
    private final JpaClubRepository jpaClubRepository;

    @Override
    public Club save(Club club) {
        return jpaClubRepository.save(club);
    }

    @Override
    public boolean existsByClubName(String clubName) {
        return jpaClubRepository.existsByClubName(clubName);
    }
}
