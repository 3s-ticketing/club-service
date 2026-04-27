package org.ticketing.club.domain.exception;

import org.ticketing.common.exception.BadRequestException;

import java.util.UUID;

public class ClubAlreadyDeletedException extends BadRequestException {

    public ClubAlreadyDeletedException(UUID clubId) {
        super("이미 삭제된 클럽입니다. id=" + clubId);
    }
}