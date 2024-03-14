package com.example.demo.infrastructure.model.repository;

import com.example.demo.aggregate.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract,Integer> {
}
