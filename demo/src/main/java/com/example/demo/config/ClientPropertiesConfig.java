package com.example.demo.config;

import com.example.demo.properties.ClientProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientPropertiesConfig {

    @Bean
    @ConfigurationProperties(prefix = "smartym")
    public ClientProperties getClientProperties() {
        return new ClientProperties();
    }
}
