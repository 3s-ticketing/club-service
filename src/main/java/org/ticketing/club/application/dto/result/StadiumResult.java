package org.ticketing.club.application.dto.result;

import org.ticketing.club.domain.model.entity.Stadium;
import org.ticketing.club.domain.model.vo.Address;

import java.util.UUID;

public record StadiumResult(
        UUID id,
        String name,
        Address address
) {
    public static StadiumResult from(Stadium stadium) {
        return new StadiumResult(
                stadium.getId(),
                stadium.getName(),
                stadium.getAddress()
        );
    }
}