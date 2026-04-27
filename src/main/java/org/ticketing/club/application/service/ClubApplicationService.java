package org.ticketing.club.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ticketing.club.application.dto.command.CreateClubCommand;
import org.ticketing.club.application.dto.command.DeleteClubCommand;
import org.ticketing.club.application.dto.command.UpdateClubAdminCommand;
import org.ticketing.club.application.dto.command.UpdateClubNameCommand;
import org.ticketing.club.application.dto.result.ClubResult;
import org.ticketing.club.domain.exception.UserNotFoundException;
import org.ticketing.club.domain.model.entity.Club;
import org.ticketing.club.domain.repository.ClubRepository;
import org.ticketing.club.domain.service.UserProvider;
import org.ticketing.common.exception.BadRequestException;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClubApplicationService {

    private final ClubRepository clubRepository;
    private final UserProvider userProvider;

    @Transactional
    public ClubResult createClub(CreateClubCommand command) {
        if (clubRepository.existsByClubName(command.clubName())) {
            throw new BadRequestException("이미 존재하는 클럽명입니다.");
        }

        if(!userProvider.existsById(command.adminId())) {
            throw new UserNotFoundException(command.adminId());
        }

        Club club = Club.create(
                command.clubName(),
                command.adminId()
        );

        return ClubResult.from(clubRepository.save(club));
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
