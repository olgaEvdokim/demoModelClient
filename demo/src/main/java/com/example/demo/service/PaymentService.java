package com.example.demo.service;

import com.example.demo.client.SmartymClient;
import com.example.demo.dto.PayloadRequest;
import com.example.demo.dto.StatusResponse;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

@Service
public class PaymentService {

    public static final String BEARER = "Bearer ";

    private final SmartymClient smartymClient;
    private final WrapperResponseCallService wrapperResponseService;

    public PaymentService(SmartymClient smartymClient, WrapperResponseCallService wrapperResponseService) {
        this.smartymClient = smartymClient;
        this.wrapperResponseService = wrapperResponseService;
    }

    public String acceptPayment(String accessToken, PayloadRequest payloadRequest){
        final Call<StatusResponse> responseCall = smartymClient.acceptPayment(BEARER + accessToken, payloadRequest);
        final StatusResponse paymentStatus = wrapperResponseService.getPaymentStatus(responseCall);
        return paymentStatus.getStatus();
    }

}
