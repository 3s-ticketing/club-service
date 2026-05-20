package org.ticketing.club.domain.exception;

import org.ticketing.common.exception.NotFoundException;

import java.util.UUID;

public class ClubNotFoundException extends NotFoundException {

    public ClubNotFoundException(UUID clubId) {
        super("클럽이 존재하지 않습니다. id=" + clubId);
    }
}