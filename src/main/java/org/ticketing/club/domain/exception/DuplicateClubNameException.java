package org.ticketing.club.domain.exception;

import org.ticketing.common.exception.BadRequestException;

public class DuplicateClubNameException extends BadRequestException {
    public DuplicateClubNameException(String name) {
        super("이미 존재하는 클럽명 : " + name);
    }
}
