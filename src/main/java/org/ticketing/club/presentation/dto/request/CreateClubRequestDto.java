package org.ticketing.club.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.ticketing.club.application.dto.command.CreateClubCommand;

import java.util.UUID;

public record CreateClubRequestDto(

        @NotBlank(message = "클럽명은 필수입니다.")
        @Size(max = 50, message = "클럽명은 50자 이하입니다.")
        String clubName,

        @NotNull(message = "관리자 ID는 필수입니다.")
        UUID adminId

) {
    public CreateClubCommand toCommand() {
        return new CreateClubCommand(
                this.clubName,
                this.adminId
        );
    }
}