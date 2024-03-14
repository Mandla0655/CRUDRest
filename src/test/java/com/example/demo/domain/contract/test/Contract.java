package com.example.demo.domain.contract.test;

import com.example.demo.domain.contract.model.Term;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Contract {

    @Test
    public void testCalculateMonthlyInstallment() {
        // Create a Term object
        Term term = Term.MONTHS_12;

        // Create a Contract object with principal amount and interest rate
        com.example.demo.domain.contract.model.Contract contract = com.example.demo.domain.contract.model.Contract.builder()
                .term(term)
                .principalAmount(new BigDecimal("1000.00"))
                .interestRate(new BigDecimal("0.05"))
                .build();

        // Call the calculateMonthlyInstallment() method
        contract.calculateMonthlyInstallment();

        // Verify that the monthly payment amount is calculated correctly
        assertEquals(new BigDecimal("85.61"), contract.getMonthlyPaymentAmount().setScale(2, BigDecimal.ROUND_HALF_UP));
    }
}
