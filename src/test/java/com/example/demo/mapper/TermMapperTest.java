package com.example.demo.mapper;

import com.example.demo.domain.contract.model.Term;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

    public class TermMapperTest {

        @Test
        public void testToDomain() {
            // Given
            com.example.demo.dto.Term dtoTerm = com.example.demo.dto.Term.MONTHS_12;

            // When
            Term domainTerm = TermMapper.INSTANCE.toDomain(dtoTerm);

            // Then
            assertNotNull(domainTerm);

            assertEquals(dtoTerm.getLength(), domainTerm.getLength());
        }

        @Test
        public void testToDto() {
            // Given
            Term domainTerm = Term.MONTHS_12;

            // When
            com.example.demo.dto.Term dtoTerm = TermMapper.INSTANCE.toDto(domainTerm);

            // Then
            assertNotNull(dtoTerm);

            assertEquals(domainTerm.getLength(), dtoTerm.getLength());
        }


}
