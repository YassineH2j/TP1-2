package com.example.demo.controller;


import com.example.demo.entity.ConversionRate;
import com.example.demo.entity.RateRequest;
import com.example.demo.service.ConversionRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ConversionRateController {
    @Autowired
    ConversionRateService conversionRateService;

    @RequestMapping(value="/conversionrate",method = RequestMethod.POST)
    public ConversionRate create(@RequestBody ConversionRate x){
        return conversionRateService.create(x);
    }

    @RequestMapping(value="/rate",method = RequestMethod.POST)
    public Double rate(@RequestBody RateRequest request) throws ParseException {
        List<ConversionRate> rates = conversionRateService.get();
        for (ConversionRate rate : rates) {
            Date requestDate=new SimpleDateFormat("yyyy/MM/dd").parse(request.date);
            Date operationStart=new SimpleDateFormat("yyyy/MM/dd").parse(rate.getValidityStartDate());
            Date operationEnd=new SimpleDateFormat("yyyy/MM/dd").parse(rate.getValidityEndDate());

            if (rate.getCurrencyFrom().equals(request.from) && rate.getCurrencyTo().equals(request.to) && operationStart.compareTo(requestDate) * requestDate.compareTo(operationEnd) >= 0){
                return rate.getRate();
            }
        }
        return 0.0;
    }


    @RequestMapping(value="/conversionrate",method = RequestMethod.GET)
    public List<ConversionRate> read(){
        return conversionRateService.get();
    }


    @RequestMapping(value="/conversionrate/{id}",method = RequestMethod.PUT)
    public ConversionRate update(@PathVariable(value="id") Long id, @RequestBody ConversionRate conversionRate){
        return conversionRateService.update(id,conversionRate);
    }

    @RequestMapping(value="/conversionrate/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable(value="id") Long id){
        conversionRateService.delete(id);
    }

}