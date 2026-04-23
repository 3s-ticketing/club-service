package org.ticketing.club.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.iimsa.common.domain.BaseEntity;

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
    private Club(UUID id, String clubName, UUID adminId) {
        this.clubName = clubName;
        this.adminId = adminId;
    }

    public static Club create(String clubName, UUID adminId) {
        return Club.builder()
                .clubName(clubName)
                .adminId(adminId)
                .build();
    }

    public void updateClub(String clubName, UUID adminId) {
        this.clubName = clubName;
        this.adminId = adminId;
    }

    public void deleteClub(String deletedBy) {
        super.delete(deletedBy);
    }
}
