package com.northstar.northstar.store.service.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StoreRequest {

    @NotBlank(message = "Name is required")
    private String name;

    private String address;

    private String region;
}
