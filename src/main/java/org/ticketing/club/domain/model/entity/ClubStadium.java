package org.ticketing.club.domain.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.iimsa.common.domain.BaseEntity;

import java.util.UUID;

@Entity
@Table(name = "p_club_stadium")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ClubStadium extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_id", nullable = false)
    private Club club;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stadium_id", nullable = false)
    private Stadium stadium;

    @Builder(access = AccessLevel.PRIVATE)
    private ClubStadium(Club club, Stadium stadium) {
        this.club = club;
        this.stadium = stadium;
    }

    public static ClubStadium create(Club club, Stadium stadium) {
        if (club == null || stadium == null) {
            throw new IllegalArgumentException("club, stadium은 필수입니다.");
        }

        return ClubStadium.builder()
                .club(club)
                .stadium(stadium)
                .build();
    }
}