package com.example.demo.service;


import com.example.demo.dto.StatusResponse;
import com.example.demo.dto.token.TokenResponse;
import com.github.lianjiatech.retrofit.spring.boot.exception.RetrofitException;
import okhttp3.ResponseBody;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.function.Supplier;

import static com.example.demo.util.Message.SOMETHING_WENT_WRONG;
import static com.example.demo.util.Message.UNKNOWN_ERROR;


@Service
public class WrapperResponseCallService {

    public TokenResponse getTokenResponse(final Call<TokenResponse> responseBodyCall) {
        return wrapResponseCall(() -> responseBodyCall);
    }

    public StatusResponse getPaymentStatus(final Call<StatusResponse> responseBodyCall) {
        return wrapResponseCall(() -> responseBodyCall);
    }

    private <T> T wrapResponseCall(final Supplier<Call<T>> responseCallSupplier) {
        try {
            final Response<T> responseBody = responseCallSupplier.get().execute();
            if (!responseBody.isSuccessful() | responseBody.body() == null) {
                ResponseBody errorResponseBody = responseBody.errorBody();
                throw new RetrofitException(errorResponseBody != null ? errorResponseBody.string() : UNKNOWN_ERROR);
            }
            return responseBody.body();
        } catch (IOException exc) {
            throw new RuntimeException(SOMETHING_WENT_WRONG);
        }
    }
}
