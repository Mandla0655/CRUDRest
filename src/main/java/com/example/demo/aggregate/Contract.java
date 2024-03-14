package com.example.demo.aggregate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@Table(name="Contract")
public class Contract {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name="term")
    private Term term;

    @Column(name="principalAmount")
    private BigDecimal principalAmount;

    @Column(name="interestRate")
    private BigDecimal interestRate;

    @Column(name="monthlyPayment")
    private BigDecimal monthlyPayment;

}
