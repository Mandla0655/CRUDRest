/*
package com.example.demo.mapper;

import com.example.demo.domain.contract.model.Contract;
import com.example.demo.domain.contract.model.Term;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContractMapperTest {

@Test
public void ContractMapperTest() {
    // Given
    Contract domainContract = Contract.builder().term(Term.MONTHS_12).build();

    // When
    com.example.demo.dto.Contract dtoContract = ContractMapper.INSTANCE.toDto(domainContract);

    // Then
    // Add assertions to verify that fields are correctly mapped
    assertEquals(domainContract.getTerm().getLength(), dtoContract.getTerm().getLength());
}

@Test
public void testToDtoFromAggregate() {
    // Given
    com.example.demo.aggregate.Contract domainContract= com.example.demo.aggregate.Contract.builder().term(com.example.demo.aggregate.Term.MONTHS_12).build();

    // When
    com.example.demo.dto.Contract dtoContract = ContractMapper.INSTANCE.toDto(domainContract);

    // Then
    // Add assertions to verify that fields are correctly mapped
    assertEquals(domainContract.getTerm().getLength(), dtoContract.getTerm().getLength());
}

@Test
public void testFromDomainToAggregate() {
    // Given
    Contract domainContract= Contract.builder().term(Term.MONTHS_12).build();

    // When
    com.example.demo.aggregate.Contract aggregateContract = ContractMapper.INSTANCE.toAggregate(domainContract);

    // Then
    // Add assertions to verify that fields are correctly mapped
    Assertions.assertEquals(domainContract.getTerm().getLength(), aggregateContract.getTerm().getLength());
}

// Add more tests for other mapping methods as needed
}


*/
