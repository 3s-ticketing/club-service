package org.ticketing.club.domain.exception;

public final class StadiumExceptionMessage {

    private StadiumExceptionMessage() {}

    // 400
    public static final String EMPTY_NAME = "경기장명은 필수입니다.";
    public static final String EMPTY_ADDRESS = "주소는 필수입니다.";

    // 404
    public static final String NOT_FOUND = "경기장이 존재하지 않습니다.";
    public static final String MAPPING_NOT_FOUND = "매핑 정보가 존재하지 않습니다.";

    // 409
    public static final String ALREADY_DELETED = "이미 삭제된 경기장입니다.";
}