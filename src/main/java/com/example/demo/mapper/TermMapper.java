package com.example.demo.mapper;

import com.example.demo.domain.contract.model.Term;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TermMapper {
    TermMapper INSTANCE = Mappers.getMapper(TermMapper.class);

    Term toDomain(com.example.demo.dto.Term term);

    com.example.demo.dto.Term toDto(Term term);

}
