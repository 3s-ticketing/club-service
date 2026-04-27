package org.ticketing.club.presentation.controller.external;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.ticketing.club.application.dto.command.DeleteClubCommand;
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
        return clubService.getClubs(keyword, pageable)
                .map(ClubResponseDto::from);
    }

    @PatchMapping("/{clubId}/name")
    public ClubResponseDto updateClubName(
            @PathVariable UUID clubId,
            @RequestBody UpdateClubNameRequestDto request
    ) {
        return ClubResponseDto.from(clubService.updateClubName(request.toCommand(clubId)));
    }

    @PatchMapping("/{clubId}/admin")
    public ClubResponseDto updateClubAdmin(
            @PathVariable UUID clubId,
            @RequestBody UpdateClubAdminRequestDto request
    ) {
        return ClubResponseDto.from(clubService.updateClubAdmin(request.toCommand(clubId)));
    }

    @DeleteMapping("/{clubId}")
    public void deleteClub(
            @PathVariable UUID clubId,
            @RequestParam UUID userId // 임시 추가(삭제를 수행하는 유저 ID)
    ) {
        clubService.deleteClub(new DeleteClubCommand(clubId, userId));
    }

    @PostMapping("/{clubId}/stadiums")
    public ClubStadiumResponseDto addStadium(
            @PathVariable UUID clubId,
            @RequestBody CreateClubStadiumRequestDto request
    ) {
        return ClubStadiumResponseDto.from(clubService.addStadium(request.toCommand(clubId)));
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
        return clubService.getClubStadiums(clubId).stream()
                .map(ClubStadiumResponseDto::from)
                .toList();
    }
}