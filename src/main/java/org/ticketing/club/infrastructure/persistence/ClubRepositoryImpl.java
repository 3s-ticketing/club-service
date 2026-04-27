package org.ticketing.club.infrastructure.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        return jpaClubRepository.existsByClubNameAndDeletedAtIsNull(clubName);
    }

    @Override
    public Optional<Club> findById(UUID id) {
        return jpaClubRepository.findByIdAndDeletedAtIsNull(id);
    }

    @Override
    public boolean existsById(UUID id) {
        return jpaClubRepository.existsByIdAndDeletedAtIsNull(id);
    }

    @Override
    public Page<Club> findAll(String keyword, Pageable pageable) {
        return jpaClubRepository.searchClubs(keyword, pageable);
    }
}
