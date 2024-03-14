package com.example.demo.mapper;

import com.example.demo.dto.Contract;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContractMapper {
    ContractMapper INSTANCE = Mappers.getMapper(ContractMapper.class);

    Contract toDto(com.example.demo.domain.contract.model.Contract contract);

    Contract toDto(com.example.demo.aggregate.Contract contract);

    com.example.demo.aggregate.Contract fromDomain(com.example.demo.domain.contract.model.Contract contract);

    com.example.demo.domain.contract.model.Contract toDomain(com.example.demo.aggregate.Contract contract);

    com.example.demo.aggregate.Contract toAggregate(com.example.demo.domain.contract.model.Contract contract);

}
