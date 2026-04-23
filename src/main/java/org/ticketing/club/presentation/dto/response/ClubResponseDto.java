package org.ticketing.club.presentation.dto.response;

import org.ticketing.club.application.dto.result.ClubResult;

import java.util.UUID;

public record ClubResponseDto(
        UUID id,
        String clubName,
        UUID adminId
) {
    public static ClubResponseDto from(ClubResult result) {
        return new ClubResponseDto(
                result.id(),
                result.clubName(),
                result.adminId()
        );
    }
}