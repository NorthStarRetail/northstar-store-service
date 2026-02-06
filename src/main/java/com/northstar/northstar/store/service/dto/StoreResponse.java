package com.northstar.northstar.store.service.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record StoreResponse(
        Long id,
        String uid,
        String name,
        String address,
        String region,
        LocalDateTime creationTime
) {
}
