package org.ticketing.club.domain.exception;

import org.ticketing.common.exception.NotFoundException;

import java.util.UUID;

public class StadiumNotFoundException extends NotFoundException {

    public StadiumNotFoundException(UUID stadiumId) {
        super("경기장이 존재하지 않습니다. id=" + stadiumId);
    }
}