package com.example.demo.repository;

import com.example.demo.entity.ConversionRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversionRateRepository extends JpaRepository<ConversionRate,Long> {
}