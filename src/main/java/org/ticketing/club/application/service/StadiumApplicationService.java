package org.ticketing.club.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.ticketing.club.presentation.dto.response.StadiumResponseDto;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StadiumApplicationService {

    public StadiumResponseDto createStadium(Object command) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public StadiumResponseDto updateStadium(Object command) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void deleteStadium(Object command) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public List<StadiumResponseDto> getAllStadiums() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public StadiumResponseDto getStadium(UUID stadiumId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public boolean existsById(UUID stadiumId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}