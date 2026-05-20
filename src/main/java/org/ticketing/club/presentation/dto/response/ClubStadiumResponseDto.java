package org.ticketing.club.presentation.dto.response;

import java.util.UUID;

import org.ticketing.club.application.dto.result.ClubStadiumResult;
import org.ticketing.club.domain.model.enums.ClubStadiumRole;

public record ClubStadiumResponseDto(
        UUID clubStadiumId,
        UUID clubId,
        UUID stadiumId,
        ClubStadiumRole role
) {

    public static ClubStadiumResponseDto from(ClubStadiumResult result) {
        return new ClubStadiumResponseDto(
                result.clubStadiumId(),
                result.clubId(),
                result.stadiumId(),
                result.role()
        );
    }
}