package com.example.demo.dto.token;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenResponse {
    private String accessToken;
    private String tokenType;
    private String expiresIn;
    @Nullable
    private String refreshToken;
    private String scope;
}
