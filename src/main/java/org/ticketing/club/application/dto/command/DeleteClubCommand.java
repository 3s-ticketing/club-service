package org.ticketing.club.application.dto.command;

import java.util.UUID;

public record DeleteClubCommand(
        UUID clubId,
        UUID deletedBy
) {
}