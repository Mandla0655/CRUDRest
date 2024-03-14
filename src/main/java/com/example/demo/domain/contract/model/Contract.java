package com.example.demo.domain.contract.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@Builder
public class Contract {
    private Term term;

    private BigDecimal principalAmount;

    private BigDecimal interestRate;

    private BigDecimal monthlyPaymentAmount;


    public void calculateMonthlyInstallment(){
        BigDecimal monthlyInterestRate = this.getInterestRate().divide(BigDecimal.valueOf(this.term.getLength()), 10, BigDecimal.ROUND_HALF_UP);

        BigDecimal numerator = monthlyInterestRate.multiply(monthlyInterestRate.add(BigDecimal.ONE).pow(this.term.getLength()));
        BigDecimal denominator = (monthlyInterestRate.add(BigDecimal.ONE).pow(this.term.getLength())).subtract(BigDecimal.ONE);
        this.monthlyPaymentAmount = this.getPrincipalAmount().multiply(numerator.divide(denominator, 10, BigDecimal.ROUND_HALF_UP));
    }

}
