package org.ticketing.club.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ticketing.club.application.dto.command.CreateClubCommand;
import org.ticketing.club.application.dto.command.DeleteClubCommand;
import org.ticketing.club.application.dto.command.UpdateClubAdminCommand;
import org.ticketing.club.application.dto.command.UpdateClubNameCommand;
import org.ticketing.club.application.dto.result.ClubResult;
import org.ticketing.club.domain.exception.ClubAlreadyDeletedException;
import org.ticketing.club.domain.exception.ClubNotFoundException;
import org.ticketing.club.domain.exception.DuplicateClubNameException;
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
            throw new DuplicateClubNameException(command.clubName());
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

    @Transactional(readOnly = true)
    public ClubResult getClub(UUID clubId) {
        Club club = clubRepository.findById(clubId)
                .orElseThrow(() -> new ClubNotFoundException(clubId));

        if (club.getDeletedAt() != null) {
            throw new ClubNotFoundException(clubId);
        }

        return ClubResult.from(club);
    }

    @Transactional
    public ClubResult updateClubName(UpdateClubNameCommand command) {
        Club club = clubRepository.findById(command.clubId())
                .orElseThrow(() -> new ClubNotFoundException(command.clubId()));

        if (clubRepository.existsByClubName(command.clubName())) {
            throw new DuplicateClubNameException(command.clubName());
        }

        club.changeClubName(command.clubName());

        return ClubResult.from(club);
    }

    @Transactional
    public ClubResult updateClubAdmin(UpdateClubAdminCommand command) {
        Club club = clubRepository.findById(command.clubId())
                .orElseThrow(() -> new ClubNotFoundException(command.clubId()));

        if (!userProvider.existsById(command.adminId())) {
            throw new UserNotFoundException(command.adminId());
        }

        club.changeAdmin(command.adminId());

        return ClubResult.from(club);
    }

    @Transactional
    public void deleteClub(DeleteClubCommand command) {
        Club club = clubRepository.findById(command.clubId())
                .orElseThrow(() -> new ClubNotFoundException(command.clubId()));

        if(club.getDeletedAt() != null) {
            throw new ClubAlreadyDeletedException(command.clubId());
        }

        club.deleteClub(command.deletedBy().toString());
    }

    @Transactional(readOnly = true)
    public boolean existsById(UUID clubId) {
        return clubRepository.findById(clubId)
                .map(club -> club.getDeletedAt() == null)
                .orElse(false);
    }
}
