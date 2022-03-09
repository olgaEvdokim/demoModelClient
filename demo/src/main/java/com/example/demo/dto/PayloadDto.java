package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayloadDto {
    private String name;
    private String iban;
    private LocalDateTime creationDateTime = LocalDateTime.now();
    private String amount;
    private String currency;
    private String remittanceInformation;
    private LocalDateTime requestedExecutionDate = LocalDateTime.now();
    private Integer numberOfTransactions;
    private String paymentInformationId;
    private String categoryPurpose;
    private String localInstrument;
    private String serviceLevel;
    private String accessToken;

}
