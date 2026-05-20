package org.ticketing.club.infrastructure.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.ticketing.club.domain.model.entity.Club;

import java.util.Optional;
import java.util.UUID;

public interface JpaClubRepository extends JpaRepository<Club, UUID> {

    boolean existsByClubNameAndDeletedAtIsNull(String clubName);

    Optional<Club> findByIdAndDeletedAtIsNull(UUID id);

    boolean existsByIdAndDeletedAtIsNull(UUID id);

    @Query("SELECT c FROM Club c WHERE (:keyword IS NULL OR c.clubName LIKE %:keyword%) AND c.deletedAt IS NULL")
    Page<Club> searchClubs(@Param("keyword") String keyword, Pageable pageable);
}
