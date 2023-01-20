package com.example.demo.repository;


import com.example.demo.entity.CoversionOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversionOperationRepository extends JpaRepository<CoversionOperation,Long> {
}