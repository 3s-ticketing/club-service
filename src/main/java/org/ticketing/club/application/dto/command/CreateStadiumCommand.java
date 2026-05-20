package org.ticketing.club.application.dto.command;

import org.ticketing.club.domain.model.vo.Address;

public record CreateStadiumCommand(

        String name,
        Address address

) {
}