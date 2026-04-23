package org.ticketing.club.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.ticketing.club.presentation.dto.response.ClubResponseDto;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClubApplicationService {

    public ClubResponseDto createClub(Object command) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public ClubResponseDto getClub(UUID clubId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public ClubResponseDto changeClubName(Object command) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public ClubResponseDto changeClubAdmin(Object command) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void deleteClub(Object command) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public boolean existsById(UUID clubId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
