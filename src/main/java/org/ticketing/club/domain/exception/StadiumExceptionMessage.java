package org.ticketing.club.domain.exception;

public final class StadiumExceptionMessage {

    private StadiumExceptionMessage() {}

    public static final String NOT_FOUND = "경기장이 존재하지 않습니다.";
    public static final String DUPLICATE_MAPPING = "이미 연결된 경기장입니다.";
    public static final String MAPPING_NOT_FOUND = "매핑 정보가 존재하지 않습니다.";
}