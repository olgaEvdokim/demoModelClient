package com.example.demo.client;

import com.example.demo.dto.PayloadRequest;
import com.example.demo.dto.StatusResponse;
import com.example.demo.dto.token.TokenResponse;
import com.github.lianjiatech.retrofit.spring.boot.annotation.RetrofitClient;
import retrofit2.Call;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

@RetrofitClient(baseUrl = "${smartym.base-url}",
        converterFactories = GsonConverterFactory.class)
public interface SmartymClient {


    @POST("/token")
    Call<TokenResponse> getAccessToken(@Query("client_id") String clientId,
                                       @Query("client_secret") String clientSecret,
                                       @Query("code") String code,
                                       @Query("scope") String scope);

    @POST("/payment-requests")
    Call<StatusResponse> acceptPayment(@Header("Authorization") String token, @Body PayloadRequest payloadRequest);
}
