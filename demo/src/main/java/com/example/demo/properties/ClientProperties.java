package com.example.demo.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientProperties {

    private String baseUrl;
    private String redirectUri;
    private String clientId;
    private String clientSecret;
    private String username;
    private String password;
    private String state;

}
