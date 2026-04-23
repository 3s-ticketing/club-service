package org.ticketing.club.application.dto.command;

import java.util.UUID;

public record CreateClubStadiumCommand(
        UUID clubId,
        UUID stadiumId
) {
}