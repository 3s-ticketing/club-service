package org.ticketing.club.presentation.controller.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.ticketing.club.application.service.ClubApplicationService;
import org.ticketing.club.application.service.StadiumApplicationService;
import org.ticketing.club.presentation.dto.response.ClubResponseDto;
import org.ticketing.club.presentation.dto.response.StadiumResponseDto;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/internal")
public class InternalController {

    private final ClubApplicationService clubService;
    private final StadiumApplicationService stadiumService;

    @GetMapping("/clubs/{clubId}")
    public ClubResponseDto getClub(@PathVariable UUID clubId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @GetMapping("/clubs/{clubId}/exists")
    public boolean existsClub(@PathVariable UUID clubId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @GetMapping("/stadiums/{stadiumId}")
    public StadiumResponseDto getStadium(@PathVariable UUID stadiumId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @GetMapping("/stadiums/{stadiumId}/exists")
    public boolean existsStadium(@PathVariable UUID stadiumId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
