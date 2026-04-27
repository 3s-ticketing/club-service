package org.ticketing.club.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ticketing.club.application.dto.command.CreateStadiumCommand;
import org.ticketing.club.application.dto.command.DeleteStadiumCommand;
import org.ticketing.club.application.dto.command.UpdateStadiumCommand;
import org.ticketing.club.application.dto.result.StadiumResult;
import org.ticketing.club.domain.exception.DuplicateStadiumNameException;
import org.ticketing.club.domain.exception.StadiumNotFoundException;
import org.ticketing.club.domain.model.entity.Stadium;
import org.ticketing.club.domain.repository.StadiumRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StadiumApplicationService {

    private final StadiumRepository stadiumRepository;

    @Transactional
    public StadiumResult createStadium(CreateStadiumCommand command) {
        if (stadiumRepository.existsByName(command.name())) {
            throw new DuplicateStadiumNameException(command.name());
        }

        Stadium stadium = Stadium.create(
                command.name(),
                command.address()
        );

        return StadiumResult.from(stadiumRepository.save(stadium));
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

    @Transactional(readOnly = true)
    public StadiumResult getStadium(UUID stadiumId) {
        Stadium stadium = stadiumRepository.findById(stadiumId)
                .orElseThrow(() -> new StadiumNotFoundException(stadiumId));
        return StadiumResult.from(stadium);
    }

    @Transactional(readOnly = true)
    public boolean existsById(UUID stadiumId) {
        return stadiumRepository.existsById(stadiumId);
    }
}