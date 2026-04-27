package org.ticketing.club.presentation.controller.external;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ticketing.club.application.service.StadiumApplicationService;
import org.ticketing.club.presentation.dto.request.CreateStadiumRequestDto;
import org.ticketing.club.presentation.dto.response.StadiumResponseDto;

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
}
