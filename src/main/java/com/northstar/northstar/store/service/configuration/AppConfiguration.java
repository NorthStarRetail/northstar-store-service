package com.northstar.northstar.store.service.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("store")
public class AppConfiguration {
    private String msg;
    private String buildVersion;
    private String baseUrl;
}
