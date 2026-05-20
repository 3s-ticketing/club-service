package org.ticketing.club.application.dto.command;

import java.util.UUID;

public record DeleteStadiumCommand(
        UUID stadiumId,
        UUID deletedBy
) {
}