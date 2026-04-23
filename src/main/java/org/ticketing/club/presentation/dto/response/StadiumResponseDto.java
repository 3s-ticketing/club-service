package org.ticketing.club.presentation.dto.response;

import org.ticketing.club.application.dto.result.StadiumResult;

import java.util.UUID;

public record StadiumResponseDto(

        UUID id,
        String name,
        String city,
        String district,
        String detail

) {
    public static StadiumResponseDto from(StadiumResult result) {
        return new StadiumResponseDto(
                result.id(),
                result.name(),
                result.address().getCity(),
                result.address().getDistrict(),
                result.address().getDetail()
        );
    }
}