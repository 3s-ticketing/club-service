package org.ticketing.club.domain.exception;

public final class ClubExceptionMessage {

    private ClubExceptionMessage() {}

    public static final String NOT_FOUND = "클럽이 존재하지 않습니다.";
    public static final String DUPLICATE_NAME = "동일한 클럽명이 존재합니다.";
    public static final String ALREADY_DELETED = "이미 삭제된 클럽입니다.";

    public static final String INVALID_ADMIN = "유효하지 않은 관리자입니다.";
    public static final String SAME_ADMIN = "동일한 관리자로 변경할 수 없습니다.";
    public static final String NOT_ADMIN = "클럽 관리자가 아닙니다.";
}