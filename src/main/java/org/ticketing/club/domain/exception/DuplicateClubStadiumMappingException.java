package org.ticketing.club.domain.exception;

import org.ticketing.common.exception.BadRequestException;

public class DuplicateClubStadiumMappingException extends BadRequestException {

    public DuplicateClubStadiumMappingException() {
        super("이미 연결된 경기장입니다.");
    }
}