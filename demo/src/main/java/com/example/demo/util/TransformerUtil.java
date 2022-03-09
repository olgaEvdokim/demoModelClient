package com.example.demo.util;

import com.example.demo.dto.*;

import static com.example.demo.util.DateFormatterUtil.parseDateToString;

public class TransformerUtil {

    public static PayloadRequest buildPayload(PayloadDto payloadDto) {
        return PayloadRequest.builder()
                .beneficiary(buildBeneficiary(payloadDto))
                .creationDateTime(parseDateToString(payloadDto.getCreationDateTime()))
                .creditTransferTransaction(buildCreditTransferTransaction(payloadDto))
                .numberOfTransactions(payloadDto.getNumberOfTransactions())
                .paymentInformationId(payloadDto.getPaymentInformationId())
                .paymentTypeInformation(buildPaymentTypeInformation(payloadDto)).build();


    }

    private static PaymentTypeInformation buildPaymentTypeInformation(PayloadDto payloadDto) {
        return PaymentTypeInformation.builder()
                .categoryPurpose(payloadDto.getCategoryPurpose())
                .localInstrument(payloadDto.getLocalInstrument())
                .serviceLevel(payloadDto.getServiceLevel())
                .build();
    }

    private static CreditTransferTransaction buildCreditTransferTransaction(PayloadDto payloadDto) {
        return CreditTransferTransaction.builder()
                .instructedAmount(buildInstructedAmount(payloadDto))
                .remittanceInformation(buildRemittanceInfo(payloadDto))
                .requestedExecutionDate(parseDateToString(payloadDto.getRequestedExecutionDate()))
                .build();
    }

    private static RemittanceInformation buildRemittanceInfo(PayloadDto payloadDto) {
        return RemittanceInformation.builder().unstructured(payloadDto.getRemittanceInformation()).build();
    }

    private static InstructedAmount buildInstructedAmount(PayloadDto payloadDto) {
        return InstructedAmount.builder().amount(payloadDto.getAmount())
                .currency(payloadDto.getCurrency()).build();
    }

    private static Beneficiary buildBeneficiary(PayloadDto payloadDto) {
        return Beneficiary.builder()
                .creditor(Creditor.builder()
                        .name(payloadDto.getName())
                        .build())
                .creditorAccount(CreditorAccount.builder()
                        .iban(payloadDto.getIban())
                        .build())
                .build();
    }
}
