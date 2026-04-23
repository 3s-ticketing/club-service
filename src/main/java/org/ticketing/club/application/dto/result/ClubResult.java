package org.ticketing.club.application.dto.result;

import java.util.UUID;

public record ClubResult(
        UUID id,
        String clubName,
        UUID adminId
) {
}
