package org.ticketing.club.infrastructure.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.ticketing.club.infrastructure.client.dto.UserExistsResponse;

import java.util.UUID;

@FeignClient(name = "user-service", path = "/internal/users")
public interface UserClient {

    @GetMapping("/{userId}")
    UserExistsResponse existsById(@PathVariable("userId") UUID userId);
}
