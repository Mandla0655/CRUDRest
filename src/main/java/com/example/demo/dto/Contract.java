package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Builder
@AllArgsConstructor
public class Contract {

    public Term term;

    public BigDecimal monthlyPaymentAmount;

    private BigDecimal principalAmount;

    private BigDecimal interestRate;

}
