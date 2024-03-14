package com.example.demo.api.test;

import com.example.demo.TechnicalError;
import com.example.demo.domain.contract.service.ContractService;
import com.example.demo.dto.Contract;
import com.example.demo.dto.ContractResponse;
import com.example.demo.dto.Term;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ContractControllerTest {

    @Mock
    private ContractService contractService;

    @InjectMocks
    private com.example.demo.api.ContractController contractController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRepaymentCalculator() {
        // Mock contract list and mapper response
        List<com.example.demo.domain.contract.model.Contract> contracts = new ArrayList<>();
        contracts.add(com.example.demo.domain.contract.model.Contract.builder().interestRate(new BigDecimal(10)).principalAmount(new BigDecimal(1700)).term(com.example.demo.domain.contract.model.Term.MONTHS_12).build());
        List<Contract> contractList = new ArrayList<>();
        contractList.add(Contract.builder().interestRate(new BigDecimal(10)).principalAmount(new BigDecimal(1700)).term(Term.MONTHS_12).build());

        // Mock service method
        when(contractService.calculateContract(any(BigDecimal.class))).thenReturn(contracts);

        // Call controller method
        ResponseEntity<ContractResponse> response = contractController.repaymentCalculator(BigDecimal.TEN);

        // Verify response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(contractList.get(0).getInterestRate(), response.getBody().getContractList().get(0).getInterestRate());
    }

    @Test
    public void testCreateContract() {
        // Mock contract list and mapper response
        List<com.example.demo.domain.contract.model.Contract> contracts = new ArrayList<>();
        contracts.add(com.example.demo.domain.contract.model.Contract.builder().interestRate(new BigDecimal(10)).principalAmount(new BigDecimal(1700)).term(com.example.demo.domain.contract.model.Term.MONTHS_12).build());
        List<Contract> contractList = new ArrayList<>();
        contractList.add(Contract.builder().interestRate(new BigDecimal(10)).principalAmount(new BigDecimal(1700)).term(Term.MONTHS_12).build());

        // Mock service method
        when(contractService.createContract(any(BigDecimal.class))).thenReturn(contracts);

        // Call controller method
        ResponseEntity<ContractResponse> response = contractController.createContract(BigDecimal.TEN);

        // Verify response
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(contractList.get(0).getInterestRate(), response.getBody().getContractList().get(0).getInterestRate());
    }

    @Test
    public void testUpdateContract() {
        // Call controller method
        ResponseEntity<Void> response = contractController.updateContract(1L, BigDecimal.TEN);

        // Verify response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(contractService, times(1)).updateContractAmount(1L, BigDecimal.TEN);
    }

    @Test
    public void testDeleteContract() {
        // Call controller method
        ResponseEntity<Void> response = contractController.deleteContract(1L);

        // Verify response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(contractService, times(1)).deleteContract(1L);
    }

    @Test
    public void testDeleteContract_Error() {
        // Mock service method to throw TechnicalError
        doThrow(TechnicalError.class).when(contractService).deleteContract(anyLong());

        // Call controller method
        try {
            contractController.deleteContract(1L);
        } catch (ResponseStatusException e) {
            // Verify response status exception
            assertEquals(HttpStatus.BAD_REQUEST, e.getStatus());
            assertEquals("Bad Request", e.getReason());
        }
    }
}
