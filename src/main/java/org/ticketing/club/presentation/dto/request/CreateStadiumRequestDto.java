package org.ticketing.club.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.ticketing.club.application.dto.command.CreateStadiumCommand;
import org.ticketing.club.domain.model.vo.Address;

public record CreateStadiumRequestDto(

        @NotBlank(message = "경기장명은 필수입니다.")
        @Size(max = 50, message = "경기장명은 50자 이하입니다.")
        String name,

        @NotNull(message = "주소는 필수입니다.")
        Address address

) {

    public CreateStadiumCommand toCommand() {
        return new CreateStadiumCommand(
                name,
                address
        );
    }
}