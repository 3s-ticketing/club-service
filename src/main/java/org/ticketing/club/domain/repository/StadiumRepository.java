package org.ticketing.club.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.ticketing.club.domain.model.entity.Stadium;

import java.util.Optional;
import java.util.UUID;

public interface StadiumRepository {

    Stadium save(Stadium stadium);

    Optional<Stadium> findById(UUID id);

    boolean existsById(UUID id);

    boolean existsByName(String name);

    Page<Stadium> findAll(String keyword, Pageable pageable);

    void flush();
}
