package org.ticketing.club.presentation.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import org.ticketing.club.application.dto.command.CreateClubStadiumCommand;
import org.ticketing.club.domain.model.enums.ClubStadiumRole;

import java.util.UUID;

public record CreateClubStadiumRequestDto(

        @NotNull(message = "경기장 ID는 필수입니다.")
        UUID stadiumId,

        @Schema(description = "HOME, SUB, TRAINING 중 하나")
        @NotNull(message = "경기장 역할은 필수입니다.")
        ClubStadiumRole role

) {

    public CreateClubStadiumCommand toCommand(UUID clubId) {
        return new CreateClubStadiumCommand(
                clubId,
                stadiumId,
                role
        );
    }
}