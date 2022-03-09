package com.example.demo.service;


import com.example.demo.client.SmartymClient;
import com.example.demo.dto.token.TokenResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;

@Component
public class AuthorizationService {
    public static final String SCOPE_AISP = "aisp";

    @Value("${smartym.client_id}")
    private String clientId;
    @Value("${smartym.client_secret}")
    private String clientSecret;

    private final SmartymClient smartymClient;
    private final WrapperResponseCallService wrapperResponseService;

    public AuthorizationService(SmartymClient smartymClient, WrapperResponseCallService wrapperResponseService) {
        this.smartymClient = smartymClient;
        this.wrapperResponseService = wrapperResponseService;
    }


    public String getToken(String authorizationCode) {
        final Call<TokenResponse> responseCallSupplier =
               smartymClient.getAccessToken(clientId, clientSecret, authorizationCode, SCOPE_AISP);
        final TokenResponse responseBody = wrapperResponseService.getTokenResponse(responseCallSupplier);
        return responseBody.getAccessToken();
    }

}
