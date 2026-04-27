package org.ticketing.club.presentation.dto.request;

import jakarta.validation.constraints.NotNull;
import org.ticketing.club.application.dto.command.UpdateClubAdminCommand;

import java.util.UUID;

public record UpdateClubAdminRequestDto(

        @NotNull(message = "관리자 ID는 필수입니다.")
        UUID adminId

) {
    public UpdateClubAdminCommand toCommand(UUID clubId) {
        return new UpdateClubAdminCommand(clubId, adminId);
    }
}