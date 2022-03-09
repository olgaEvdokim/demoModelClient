package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditTransferTransaction {

    private InstructedAmount instructedAmount;
    private RemittanceInformation remittanceInformation;
    private String requestedExecutionDate;

}
