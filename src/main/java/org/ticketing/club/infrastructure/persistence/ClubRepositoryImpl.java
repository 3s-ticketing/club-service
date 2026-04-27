package org.ticketing.club.infrastructure.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.ticketing.club.domain.model.entity.Club;
import org.ticketing.club.domain.repository.ClubRepository;

import java.util.Optional;
import java.util.UUID;

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

    @Override
    public Optional<Club> findById(UUID id) {
        return jpaClubRepository.findById(id);
    }
}
