package org.ticketing.club.infrastructure.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.ticketing.club.domain.model.entity.Stadium;
import org.ticketing.club.domain.repository.StadiumRepository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class StadiumRepositoryImpl implements StadiumRepository {

    private final JpaStadiumRepository jpaStadiumRepository;

    @Override
    public Stadium save(Stadium stadium) {
        return jpaStadiumRepository.save(stadium);
    }

    @Override
    public Optional<Stadium> findById(UUID id) {
        return jpaStadiumRepository.findByIdAndDeletedAtIsNull(id);
    }

    @Override
    public boolean existsById(UUID id) {
        return jpaStadiumRepository.existsByIdAndDeletedAtIsNull(id);
    }
}
