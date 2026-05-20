package org.ticketing.club.application.dto.command;

import org.ticketing.club.domain.model.enums.ClubStadiumRole;

import java.util.UUID;

public record CreateClubStadiumCommand(
        UUID clubId,
        UUID stadiumId,
        ClubStadiumRole role
) {
}