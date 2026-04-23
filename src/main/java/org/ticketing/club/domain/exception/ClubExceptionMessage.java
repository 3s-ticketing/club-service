package org.ticketing.club.domain.exception;

public final class ClubExceptionMessage {

    private ClubExceptionMessage() {}

    // 400
    public static final String EMPTY_NAME = "클럽명은 필수입니다.";
    public static final String INVALID_NAME = "클럽명이 유효하지 않습니다.";
    public static final String EMPTY_ADMIN_ID = "관리자 ID는 필수입니다.";
    public static final String INVALID_ADMIN = "유효하지 않은 관리자입니다.";
    public static final String CLUB_STADIUM_REQUIRED = "클럽과 경기장은 필수입니다.";

    // 403
    public static final String FORBIDDEN = "해당 클럽에 접근 권한이 없습니다.";
    public static final String NOT_ADMIN = "관리자가 아닙니다.";

    // 404
    public static final String NOT_FOUND = "클럽이 존재하지 않습니다.";

    // 409
    public static final String DUPLICATE_NAME = "동일한 클럽명이 존재합니다.";
    public static final String ALREADY_DELETED = "이미 삭제된 클럽입니다.";
}