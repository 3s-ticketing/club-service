package org.ticketing.club.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.ticketing.club.application.dto.result.ClubResult;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClubApplicationService {

    public ClubResult createClub(Object command) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public ClubResult getClub(UUID clubId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public ClubResult changeClubName(Object command) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public ClubResult changeClubAdmin(Object command) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void deleteClub(Object command) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public boolean existsById(UUID clubId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
