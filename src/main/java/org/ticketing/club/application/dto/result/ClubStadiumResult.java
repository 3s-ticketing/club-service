package org.ticketing.club.application.dto.result;

import org.ticketing.club.domain.model.enums.ClubStadiumRole;

import java.util.UUID;

public record ClubStadiumResult(
        UUID clubStadiumId,
        UUID clubId,
        UUID stadiumId,
        ClubStadiumRole role
) {}
