package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PayloadRequest {

    private Beneficiary beneficiary;
    private String creationDateTime;
    private CreditTransferTransaction creditTransferTransaction;
    private Integer numberOfTransactions;
    private String paymentInformationId;
    private PaymentTypeInformation paymentTypeInformation;
}
