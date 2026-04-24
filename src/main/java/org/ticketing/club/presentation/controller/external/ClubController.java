package org.ticketing.club.presentation.controller.external;

import lombok.RequiredArgsConstructor;
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
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @GetMapping("/{clubId}")
    public ClubResponseDto getClub(
            @PathVariable UUID clubId
    ) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @GetMapping
    public List<ClubResponseDto> getClubs(
            @RequestParam(required = false) Object keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
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
            @PathVariable UUID clubId,
            @RequestParam(required = false) String deletedBy
    ) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @PostMapping("/{clubId}/stadiums")
    public void addStadium(
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