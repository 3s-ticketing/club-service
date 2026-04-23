package org.ticketing.club.domain.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.ticketing.club.domain.exception.*;
import org.ticketing.common.domain.BaseEntity;
import org.ticketing.common.exception.BadRequestException;

import java.util.UUID;

@Entity
@Table(name = "p_club")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Club extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "club_name", nullable = false, unique = true, length = 50)
    private String clubName;

    @Column(name = "admin_id", nullable = false)
    private UUID adminId;

    @Builder(access = AccessLevel.PRIVATE)
    private Club(String clubName, UUID adminId) {
        this.clubName = clubName;
        this.adminId = adminId;
    }

    public static Club create(String clubName, UUID adminId) {
        validate(clubName, adminId);

        return Club.builder()
                .clubName(clubName)
                .adminId(adminId)
                .build();
    }

    public void changeClubName(String clubName) {
        ensureNotDeleted();
        if (clubName == null || clubName.isBlank()) {
            throw new BadRequestException("클럽명은 필수입니다");
        }
        if (clubName.length() > 50) {
            throw new BadRequestException("클럽명은 50자를 초과할 수 없습니다");
        }

        this.clubName = clubName;
    }

    public void changeAdmin(UUID adminId) {
        ensureNotDeleted();
        if (adminId == null) {
            throw new BadRequestException("관리자 ID는 필수입니다");
        }

        this.adminId = adminId;
    }

    public void deleteClub(String deletedBy) {
        ensureNotDeleted();
        super.delete(deletedBy);
    }

    private static void validate(String clubName, UUID adminId) {
        if (clubName == null || clubName.isBlank()) {
            throw new BadRequestException("클럽명은 필수입니다");
        }
        if (clubName.length() > 50) {
            throw new BadRequestException("클럽명은 50자를 초과할 수 없습니다");
        }
        if (adminId == null) {
            throw new BadRequestException("관리자 ID는 필수입니다");
        }
    }

    private void ensureNotDeleted() {
        if (this.deletedAt != null) {
            throw new ClubAlreadyDeletedException(this.id);
        }
    }
}
