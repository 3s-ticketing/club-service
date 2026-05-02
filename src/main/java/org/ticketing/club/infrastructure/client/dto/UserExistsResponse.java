package org.ticketing.club.infrastructure.client.dto;

public record UserExistsResponse(
        boolean success,
        String message,
        Boolean data,
        String traceId
) {
}
