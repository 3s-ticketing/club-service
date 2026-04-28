package org.ticketing.club.domain.exception;

import org.ticketing.common.exception.NotFoundException;

import java.util.UUID;

public class ClubStadiumNotFoundException extends NotFoundException {

    public ClubStadiumNotFoundException(UUID clubId, UUID stadiumId) {
        super("클럽(" + clubId + ")에 경기장(" + stadiumId + ")이 등록되어 있지 않습니다.");
    }
}