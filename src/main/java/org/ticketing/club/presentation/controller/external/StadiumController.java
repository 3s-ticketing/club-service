package org.ticketing.club.presentation.controller.external;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.ticketing.club.application.service.StadiumApplicationService;
import org.ticketing.club.application.dto.command.DeleteStadiumCommand;
import org.ticketing.club.presentation.dto.request.CreateStadiumRequestDto;
import org.ticketing.club.presentation.dto.request.UpdateStadiumRequestDto;
import org.ticketing.club.presentation.dto.response.StadiumResponseDto;

import java.util.List;
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

    @GetMapping
    public Page<StadiumResponseDto> getStadiums(
            @RequestParam(required = false) String keyword,
            @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        return stadiumService.getStadiums(keyword, pageable)
                .map(StadiumResponseDto::from);
    }

    @GetMapping("/{stadiumId}")
    public StadiumResponseDto getStadium(
            @PathVariable UUID stadiumId
    ) {
        return StadiumResponseDto.from(stadiumService.getStadium(stadiumId));
    }

    @PutMapping("/{stadiumId}")
    public StadiumResponseDto updateStadium(
            @PathVariable UUID stadiumId,
            @RequestBody @Valid UpdateStadiumRequestDto request
    ) {
        return StadiumResponseDto.from(stadiumService.updateStadium(request.toCommand(stadiumId)));
    }

    @DeleteMapping("/{stadiumId}")
    public void deleteStadium(
            @PathVariable UUID stadiumId,
            @RequestParam UUID userId   // 임시 추가(삭제를 수행하는 유저 ID)
    ) {
        stadiumService.deleteStadium(new DeleteStadiumCommand(stadiumId, userId));
    }
}
