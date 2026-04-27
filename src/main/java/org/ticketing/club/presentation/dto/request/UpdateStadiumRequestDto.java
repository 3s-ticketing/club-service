package org.ticketing.club.presentation.dto.request;

import org.ticketing.club.application.dto.command.UpdateStadiumCommand;
import org.ticketing.club.domain.model.vo.Address;

import java.util.UUID;

public record UpdateStadiumRequestDto(

        String name,
        Address address

) {

    public UpdateStadiumCommand toCommand(UUID stadiumId) {
        return new UpdateStadiumCommand(
                stadiumId,
                name,
                address
        );
    }
}