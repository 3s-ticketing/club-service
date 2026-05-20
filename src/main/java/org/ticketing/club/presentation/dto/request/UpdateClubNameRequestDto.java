package org.ticketing.club.presentation.dto.request;

import org.ticketing.club.application.dto.command.UpdateClubNameCommand;

import java.util.UUID;

public record UpdateClubNameRequestDto(

        String clubName

) {
    public UpdateClubNameCommand toCommand(UUID clubId) {
        return new UpdateClubNameCommand(clubId, clubName);
    }
}
