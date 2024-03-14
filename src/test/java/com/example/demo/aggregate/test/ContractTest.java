package com.example.demo.aggregate.test;

import com.example.demo.aggregate.Contract;
import com.example.demo.aggregate.Term;
import org.junit.jupiter.api.Test;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ContractTest {

    @Test
    public void testContractAnnotations() {
        // Given
        Class<Contract> contractClass = Contract.class;

        // When
        Entity entityAnnotation = contractClass.getAnnotation(Entity.class);
        Table tableAnnotation = contractClass.getAnnotation(Table.class);

        // Then
        assertNotNull(entityAnnotation, "@Entity annotation should be present");
        assertNotNull(tableAnnotation, "@Table annotation should be present");
        assertEquals("Contract", tableAnnotation.name(), "Table name should be 'Contract'");
    }

    @Test
    public void testGettersAndSetters() {
        // Given
        Contract contract = new Contract();
        Term term = Term.MONTHS_12;
        BigDecimal principalAmount = BigDecimal.valueOf(1000);
        BigDecimal interestRate = BigDecimal.valueOf(0.05);
        BigDecimal monthlyPayment = BigDecimal.valueOf(100);

        // When
        contract.setId(1);
        contract.setTerm(term);
        contract.setPrincipalAmount(principalAmount);
        contract.setInterestRate(interestRate);
        contract.setMonthlyPayment(monthlyPayment);

        // Then
        assertEquals(1, contract.getId(), "Id should be set correctly");
        assertEquals(term, contract.getTerm(), "Term should be set correctly");
        assertEquals(principalAmount, contract.getPrincipalAmount(), "Principal amount should be set correctly");
        assertEquals(interestRate, contract.getInterestRate(), "Interest rate should be set correctly");
        assertEquals(monthlyPayment, contract.getMonthlyPayment(), "Monthly payment should be set correctly");
    }
}

