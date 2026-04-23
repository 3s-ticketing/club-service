package org.ticketing.club.domain.exception;

import org.ticketing.common.exception.BadRequestException;

import java.util.UUID;

public class StadiumAlreadyDeletedException extends BadRequestException {

    public StadiumAlreadyDeletedException(UUID stadiumId) {
        super("이미 삭제된 경기장입니다. id=" + stadiumId);
    }
}