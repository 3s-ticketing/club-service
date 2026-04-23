package org.ticketing.club.application.dto.command;

import org.ticketing.club.domain.model.vo.Address;

import java.util.UUID;

public record UpdateStadiumCommand(

        UUID stadiumId,
        String name,
        Address address

) {
}