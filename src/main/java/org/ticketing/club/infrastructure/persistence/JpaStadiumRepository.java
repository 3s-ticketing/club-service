package org.ticketing.club.infrastructure.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.ticketing.club.domain.model.entity.Stadium;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JpaStadiumRepository extends JpaRepository<Stadium, UUID> {

    Optional<Stadium> findByIdAndDeletedAtIsNull(UUID id);

    boolean existsByIdAndDeletedAtIsNull(UUID id);

    boolean existsByNameAndDeletedAtIsNull(String name);

    List<Stadium> findAllByDeletedAtIsNull();

    @Query("SELECT s FROM Stadium s WHERE (:keyword IS NULL OR s.name LIKE %:keyword%) AND s.deletedAt IS NULL")
    Page<Stadium> searchStadiums(@Param("keyword") String keyword, Pageable pageable);
}
