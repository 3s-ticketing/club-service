package org.ticketing.club.application.dto.result;

import org.ticketing.club.domain.model.entity.Club;

import java.util.UUID;

public record ClubResult(
        UUID id,
        String clubName,
        UUID adminId
) {
    public static ClubResult from(Club club) {
        return new ClubResult(
                club.getId(),
                club.getClubName(),
                club.getAdminId()
        );
    }
}
