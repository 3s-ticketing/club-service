package org.ticketing.club.infrastructure.provider;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.ticketing.club.domain.exception.UserNotFoundException;
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

        if(response == null || !response.success() || response.data() == null) {
            throw new IllegalStateException("user-service 응답이 비정상입니다. traceId=" +
                    (response != null ? response.traceId() : "null"));
        }

        return response.data();
    }
}
