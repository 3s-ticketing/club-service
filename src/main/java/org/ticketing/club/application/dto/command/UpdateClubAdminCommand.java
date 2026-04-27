package org.ticketing.club.application.dto.command;

import java.util.UUID;

public record UpdateClubAdminCommand(
        UUID clubId,
        UUID adminId
) {
}