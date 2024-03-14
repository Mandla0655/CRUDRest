package com.example.demo.domain.contract.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Term {

    MONTHS_12(12),
    MONTHS_24(24),
    MONTHS_36(36);

    private int length;

}
