package org.ticketing.club.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.ticketing.club.application.dto.command.CreateStadiumCommand;
import org.ticketing.club.application.dto.command.DeleteStadiumCommand;
import org.ticketing.club.application.dto.command.UpdateStadiumCommand;
import org.ticketing.club.application.dto.result.StadiumResult;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StadiumApplicationService {

    public StadiumResult createStadium(CreateStadiumCommand createStadiumCommand) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public StadiumResult updateStadium(UpdateStadiumCommand updateStadiumCommand) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void deleteStadium(DeleteStadiumCommand deleteStadiumCommand) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public List<StadiumResult> getAllStadiums() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public StadiumResult getStadium(UUID stadiumId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public boolean existsById(UUID stadiumId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}