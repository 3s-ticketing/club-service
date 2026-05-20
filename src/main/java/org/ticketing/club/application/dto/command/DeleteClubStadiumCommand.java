package org.ticketing.club.application.dto.command;

import java.util.UUID;

public record DeleteClubStadiumCommand(
        UUID clubId,
        UUID stadiumId,
        UUID deletedBy
) {
}