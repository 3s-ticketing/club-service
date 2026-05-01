package org.ticketing.club.infrastructure.provider;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.ticketing.club.domain.service.UserProvider;
import org.ticketing.club.infrastructure.client.UserClient;
import org.ticketing.club.infrastructure.client.dto.UserExistsResponse;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserProviderImpl implements UserProvider {

    private final UserClient userClient;

    @Override
    public boolean existsById(UUID userId) {
        UserExistsResponse response = userClient.existsById(userId);

        return response != null && Boolean.TRUE.equals(response.data());
    }
}
