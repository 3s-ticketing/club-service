package org.ticketing.club.domain.service;

import java.util.UUID;

public interface UserProvider {
    boolean existsById(UUID userId);
}
