package org.ticketing.club.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.ticketing.club.application.dto.command.CreateClubCommand;
import org.ticketing.club.application.dto.command.DeleteClubCommand;
import org.ticketing.club.application.dto.command.UpdateClubAdminCommand;
import org.ticketing.club.application.dto.command.UpdateClubNameCommand;
import org.ticketing.club.application.dto.result.ClubResult;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClubApplicationService {

    public ClubResult createClub(CreateClubCommand createClubCommand) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public ClubResult getClub(UUID clubId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public ClubResult updateClubName(UpdateClubNameCommand updateClubNameCommand) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public ClubResult updateClubAdmin(UpdateClubAdminCommand updateClubAdminCommand) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void deleteClub(DeleteClubCommand deleteClubCommand) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public boolean existsById(UUID clubId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
