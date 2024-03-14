package com.example.demo.api;

import com.example.demo.TechnicalError;
import com.example.demo.domain.contract.service.ContractService;
import com.example.demo.dto.Contract;
import com.example.demo.dto.ContractResponse;
import com.example.demo.mapper.ContractMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.websocket.server.PathParam;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private ContractService contractService;

    @GetMapping
    public ResponseEntity<ContractResponse> repaymentCalculator(@NotBlank(message = "this field needs to be provided") @Valid BigDecimal amount ){
        List<Contract> contractList = contractService.calculateContract(amount).stream().map(contract -> ContractMapper.INSTANCE.toDto(contract)).collect(Collectors.toList());
        return ResponseEntity.ok(ContractResponse.builder().contractList(contractList).build()) ;
    }

    @PostMapping
    public ResponseEntity<ContractResponse> createContract(@NotBlank(message = "this argument needs to be provided") @Valid @RequestBody BigDecimal amount ){
        List<com.example.demo.domain.contract.model.Contract> contracts = contractService.createContract(amount);
        return new ResponseEntity<>(ContractResponse.builder().contractList(contracts.stream().map(contract -> ContractMapper.INSTANCE.toDto(contract)).collect(Collectors.toList())).build() , HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateContract(@PathParam("id") @NotBlank(message = "this argument needs to be provided") @Valid @PathVariable Long id, @NotBlank(message = "this argument needs to be provided") @Valid @RequestBody BigDecimal amount){
        contractService.updateContractAmount(id,amount);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContract(@NotBlank(message = "this argument needs to be provided") @Valid  @PathVariable("id") Long id){
        try {
            contractService.deleteContract(id);
        } catch (TechnicalError e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Bad Request",e);
        }
        return ResponseEntity.ok().build();
    }


}
