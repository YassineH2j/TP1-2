package com.example.demo.entity;

import javax.persistence.*;

@Entity(name = "conversionRate") // This tells Hibernate to make a table out of this class
public class CoversionOperation {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="operation_id")
    private Long OperationId;

    @Column(name="currency_from")
    private String currencyFrom;

    @Column(name="currency_to")
    private String currencyTo;

    @Column(name="conversion_rate")
    private Double ConversionRate;

    @Column(name="initial_amount")
    private Double initialAmount;

    @Column(name="converted_amount")
    private Double convertedAmount;

    public CoversionOperation(Long operationId, String currencyFrom, String currencyTo, Double conversionRate, Double initialAmount, Double convertedAmount) {
        OperationId = operationId;
        this.currencyFrom = currencyFrom;
        this.currencyTo = currencyTo;
        ConversionRate = conversionRate;
        this.initialAmount = initialAmount;
        this.convertedAmount = convertedAmount;
    }

    public CoversionOperation() {
    }

    public Long getOperationId() {
        return OperationId;
    }

    public void setOperationId(Long operationId) {
        OperationId = operationId;
    }

    public String getCurrencyFrom() {
        return currencyFrom;
    }

    public void setCurrencyFrom(String currencyFrom) {
        this.currencyFrom = currencyFrom;
    }

    public String getCurrencyTo() {
        return currencyTo;
    }

    public void setCurrencyTo(String currencyTo) {
        this.currencyTo = currencyTo;
    }

    public Double getConversionRate() {
        return ConversionRate;
    }

    public void setConversionRate(Double conversionRate) {
        ConversionRate = conversionRate;
    }

    public Double getInitialAmount() {
        return initialAmount;
    }

    public void setInitialAmount(Double initialAmount) {
        this.initialAmount = initialAmount;
    }

    public Double getConvertedAmount() {
        return convertedAmount;
    }

    public void setConvertedAmount(Double convertedAmount) {
        this.convertedAmount = convertedAmount;
    }
}