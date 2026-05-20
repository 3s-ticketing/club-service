package org.ticketing.club.infrastructure.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.ticketing.club.domain.model.entity.ClubStadium;
import org.ticketing.club.domain.repository.ClubStadiumRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class ClubStadiumRepositoryImpl implements ClubStadiumRepository {

    private final JpaClubStadiumRepository jpaClubStadiumRepository;

    @Override
    public ClubStadium save(ClubStadium clubStadium) {
        return jpaClubStadiumRepository.save(clubStadium);
    }

    @Override
    public boolean existsByClubIdAndStadiumId(UUID clubId, UUID stadiumId) {
        return jpaClubStadiumRepository.existsByClubIdAndStadiumIdAndDeletedAtIsNull(clubId, stadiumId);
    }

    @Override
    public List<ClubStadium> findAllByClubId(UUID clubId) {
        return jpaClubStadiumRepository.findAllByClubIdAndDeletedAtIsNull(clubId);
    }

    @Override
    public Optional<ClubStadium> findByClubIdAndStadiumId(UUID clubId, UUID stadiumId) {
        return jpaClubStadiumRepository.findByClubIdAndStadiumIdAndDeletedAtIsNull(clubId, stadiumId);
    }
}
