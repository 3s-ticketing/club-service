package org.ticketing.club.application.dto.result;

import org.ticketing.club.domain.model.entity.ClubStadium;
import org.ticketing.club.domain.model.enums.ClubStadiumRole;

import java.util.UUID;

public record ClubStadiumResult(
        UUID clubStadiumId,
        UUID clubId,
        UUID stadiumId,
        ClubStadiumRole role
) {
    public static ClubStadiumResult from(ClubStadium clubStadium) {
        return new ClubStadiumResult(
                clubStadium.getId(),
                clubStadium.getClub().getId(),
                clubStadium.getStadium().getId(),
                clubStadium.getRole()
        );
    }
}
