package org.ticketing.club.application.dto.command;

import java.util.UUID;

public record CreateClubCommand(
        String clubName,
        UUID adminId
) {
}