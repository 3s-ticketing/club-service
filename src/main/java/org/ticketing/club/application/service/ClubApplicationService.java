package org.ticketing.club.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ticketing.club.application.dto.command.*;
import org.ticketing.club.application.dto.result.ClubResult;
import org.ticketing.club.application.dto.result.ClubStadiumResult;
import org.ticketing.club.domain.exception.*;
import org.ticketing.club.domain.model.entity.Club;
import org.ticketing.club.domain.model.entity.ClubStadium;
import org.ticketing.club.domain.model.entity.Stadium;
import org.ticketing.club.domain.repository.ClubRepository;
import org.ticketing.club.domain.repository.ClubStadiumRepository;
import org.ticketing.club.domain.repository.StadiumRepository;
import org.ticketing.club.domain.service.UserProvider;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClubApplicationService {

    private final ClubRepository clubRepository;
    private final StadiumRepository stadiumRepository;
    private final ClubStadiumRepository clubStadiumRepository;
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
        return ClubResult.from(club);
    }

    @Transactional(readOnly = true)
    public Page<ClubResult> getClubs(String keyword, Pageable pageable) {
        return clubRepository.findAll(keyword, pageable)
                .map(ClubResult::from);
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

        club.deleteClub(command.deletedBy().toString());
    }

    @Transactional(readOnly = true)
    public boolean existsById(UUID clubId) {
        return clubRepository.existsById(clubId);
    }
}
