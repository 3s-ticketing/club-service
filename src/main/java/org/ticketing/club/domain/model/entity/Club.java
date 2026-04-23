package org.ticketing.club.domain.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.iimsa.common.domain.BaseEntity;
import org.iimsa.common.exception.BadRequestException;
import org.iimsa.common.exception.ForbiddenException;
import org.ticketing.club.domain.exception.ClubExceptionMessage;

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

    public void updateClub(String clubName, UUID adminId) {
        if (this.deletedAt != null) {
            throw new BadRequestException(ClubExceptionMessage.ALREADY_DELETED);
        }

        if (clubName != null && !clubName.isBlank()) {
            this.clubName = clubName;
        }

        if (adminId != null) {
            this.adminId = adminId;
        }
    }

    public void deleteClub(String deletedBy) {
        if (this.deletedAt != null) {
            throw new BadRequestException(ClubExceptionMessage.ALREADY_DELETED);
        }
        super.delete(deletedBy);
    }

    private static void validate(String clubName, UUID adminId) {
        if (clubName == null || clubName.isBlank()) {
            throw new BadRequestException(ClubExceptionMessage.EMPTY_NAME);
        }
        if (adminId == null) {
            throw new BadRequestException(ClubExceptionMessage.EMPTY_ADMIN_ID);
        }
    }
}
