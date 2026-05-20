package org.ticketing.club.application.dto.command;

import java.util.UUID;

public record UpdateClubNameCommand(
        UUID clubId,
        String clubName
) {
}