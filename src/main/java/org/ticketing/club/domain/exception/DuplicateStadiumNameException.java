package org.ticketing.club.domain.exception;

import org.ticketing.common.exception.BadRequestException;

public class DuplicateStadiumNameException extends BadRequestException {
    public DuplicateStadiumNameException(String name) {
        super("이미 존재하는 경기장 이름입니다 : " + name);
    }
}
