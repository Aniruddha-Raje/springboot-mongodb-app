package com.example.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "app")
@Getter
@Setter
@Component
public class Config {

    @Value("${app.jsonPlaceholderUrl}")
    private String jsonPlaceholderUrl;
    private String baseUrl;
    private String path;
}
