package org.ticketing.club.presentation.dto.request;

import jakarta.validation.constraints.NotNull;
import org.ticketing.club.application.dto.command.CreateClubStadiumCommand;

import java.util.UUID;

public record CreateClubStadiumRequestDto(

        @NotNull(message = "경기장 ID는 필수입니다.")
        UUID stadiumId

) {

    public CreateClubStadiumCommand toCommand(UUID clubId) {
        return new CreateClubStadiumCommand(
                clubId,
                stadiumId
        );
    }
}