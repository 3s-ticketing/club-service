package org.ticketing.club.presentation.controller.external;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.ticketing.club.application.service.StadiumApplicationService;
import org.ticketing.club.presentation.dto.request.CreateStadiumRequestDto;
import org.ticketing.club.presentation.dto.response.StadiumResponseDto;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/stadiums")
public class StadiumController {

    private final StadiumApplicationService stadiumService;

    @PostMapping
    public StadiumResponseDto createStadium(
            @RequestBody @Valid CreateStadiumRequestDto request
    ) {
        return StadiumResponseDto.from(stadiumService.createStadium(request.toCommand()));
    }

    @GetMapping("/{stadiumId}")
    public StadiumResponseDto getStadium(
            @PathVariable UUID stadiumId
    ) {
        return StadiumResponseDto.from(stadiumService.getStadium(stadiumId));
    }
}
