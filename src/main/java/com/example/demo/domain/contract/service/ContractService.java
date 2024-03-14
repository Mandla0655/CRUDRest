package com.example.demo.domain.contract.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.demo.TechnicalError;
import com.example.demo.domain.contract.model.Contract;
import com.example.demo.domain.contract.model.Term;
import com.example.demo.infrastructure.model.repository.ContractRepository;
import com.example.demo.mapper.ContractMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ContractService {
    private static final Logger logger = LoggerFactory.getLogger(ContractService.class);
    private final static BigDecimal PERCENTAGE = BigDecimal.valueOf(0.065);

    @Autowired
    private ContractRepository contractRepository;


    public List<Contract> createContract(BigDecimal amount){
        logger.info("the request has arrived");
        List<com.example.demo.aggregate.Contract> contractList = calculateContract(amount).stream().map(contract ->  ContractMapper.INSTANCE.toAggregate(contract)).collect(Collectors.toList());

        return contractRepository.saveAll(contractList).stream().map(contract -> ContractMapper.INSTANCE.toDomain(contract)).collect(Collectors.toList());
    }

    public List<Contract> calculateContract(BigDecimal amount){

        List<Contract> contractList = Stream.of(Term.values()).map(term1 -> {
            return createContract(term1,amount);
        }).collect(Collectors.toList());

        return contractList;
    }

    private Contract createContract(com.example.demo.domain.contract.model.Term term, BigDecimal amount){
        Contract contract = Contract.builder()
                .interestRate(PERCENTAGE)
                .term(term)
                .principalAmount(amount)
                .build();
        contract.calculateMonthlyInstallment();
        return contract;
    }

    public void deleteContract(Long id) throws TechnicalError {
        if(id < 0){
            logger.error("this request failed");
            throw new TechnicalError("teh value provided is negative");
        }

        this.contractRepository.deleteById(id.intValue());
    }

    public void updateContractAmount(Long id, BigDecimal amount) {
        if(contractRepository.existsById(id.intValue())){
            Optional<com.example.demo.aggregate.Contract> contract = contractRepository.findById(id.intValue());
            contract.get().setPrincipalAmount(amount);
            contractRepository.save(contract.get());
        }

    }
}
