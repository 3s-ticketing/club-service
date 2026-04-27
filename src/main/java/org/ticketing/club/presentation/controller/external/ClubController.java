package org.ticketing.club.presentation.controller.external;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.ticketing.club.application.service.ClubApplicationService;
import org.ticketing.club.presentation.dto.request.*;
import org.ticketing.club.presentation.dto.response.ClubResponseDto;
import org.ticketing.club.presentation.dto.response.ClubStadiumResponseDto;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/clubs")
public class ClubController {

    private final ClubApplicationService clubService;

    @PostMapping
    public ClubResponseDto createClub(
            @RequestBody CreateClubRequestDto request
    ) {
        return ClubResponseDto.from(clubService.createClub(request.toCommand()));
    }

    @GetMapping("/{clubId}")
    public ClubResponseDto getClub(
            @PathVariable UUID clubId
    ) {
        return ClubResponseDto.from(clubService.getClub(clubId));
    }

    @GetMapping
    public Page<ClubResponseDto> getClubs(
            @RequestParam(required = false) String keyword,
            @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @PatchMapping("/{clubId}/name")
    public ClubResponseDto updateClubName(
            @PathVariable UUID clubId,
            @RequestBody UpdateClubNameRequestDto request
    ) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @PatchMapping("/{clubId}/admin")
    public ClubResponseDto updateClubAdmin(
            @PathVariable UUID clubId,
            @RequestBody UpdateClubAdminRequestDto request
    ) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @DeleteMapping("/{clubId}")
    public void deleteClub(
            @PathVariable UUID clubId
    ) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @PostMapping("/{clubId}/stadiums")
    public ClubStadiumResponseDto addStadium(
            @PathVariable UUID clubId,
            @RequestBody CreateClubStadiumRequestDto request
    ) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @DeleteMapping("/{clubId}/stadiums/{stadiumId}")
    public void removeStadium(
            @PathVariable UUID clubId,
            @PathVariable UUID stadiumId
    ) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @GetMapping("/{clubId}/stadiums")
    public List<ClubStadiumResponseDto> getClubStadiums(@PathVariable UUID clubId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}