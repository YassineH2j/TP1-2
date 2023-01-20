package com.example.demo.service;


import com.example.demo.entity.ConversionRate;
import com.example.demo.repository.ConversionRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConversionRateService {
    @Autowired
    ConversionRateRepository conversionRateRepository;

    public List<ConversionRate> get () {
        return conversionRateRepository.findAll();
    }

    public ConversionRate create(ConversionRate x){
        return conversionRateRepository.save(x);
    }

    public void delete(Long id){
        conversionRateRepository.deleteById(id);
    }

    public ConversionRate update(Long id, ConversionRate conversionRate){
        ConversionRate conversionRate1 = conversionRateRepository.findById(id).get();
        conversionRate1.setRateId(conversionRate.getRateId());
        conversionRate1.setCurrencyFrom(conversionRate.getCurrencyFrom());
        conversionRate1.setCurrencyTo(conversionRate.getCurrencyTo());
        conversionRate1.setValidityEndDate(conversionRate.getValidityEndDate());
        conversionRate1.setValidityStartDate(conversionRate.getValidityStartDate());
        return conversionRateRepository.save(conversionRate1);
    }
}