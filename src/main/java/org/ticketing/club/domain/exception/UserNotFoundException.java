package org.ticketing.club.domain.exception;

import org.ticketing.common.exception.NotFoundException;

import java.util.UUID;

public class UserNotFoundException extends NotFoundException {

    public UserNotFoundException(UUID userId) {
        super("유저가 존재하지 않습니다. id=" + userId);
    }
}
