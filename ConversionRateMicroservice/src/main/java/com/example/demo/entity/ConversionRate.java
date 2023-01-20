package com.example.demo.entity;
import javax.persistence.*;

@Entity(name = "conversionRate") // This tells Hibernate to make a table out of this class
public class ConversionRate {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="rate_id")
    private Long RateId;

    @Column(name="currency_from")
    private String currencyFrom;

    @Column(name="currency_to")
    private String currencyTo;

    @Column(name="rate")
    private Double rate;

    @Column(name="start")
    private String validityStartDate;

    @Column(name="end")
    private String validityEndDate;

    public ConversionRate(Long rateId, String currencyFrom, String currencyTo, Double rate, String validityStartDate, String validityEndDate) {
        RateId = rateId;
        this.currencyFrom = currencyFrom;
        this.currencyTo = currencyTo;
        this.rate = rate;
        this.validityStartDate = validityStartDate;
        this.validityEndDate = validityEndDate;
    }

    public ConversionRate() {
    }

    public Long getRateId() {
        return RateId;
    }

    public void setRateId(Long rateId) {
        RateId = rateId;
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

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getValidityStartDate() {
        return validityStartDate;
    }

    public void setValidityStartDate(String validityStartDate) {
        this.validityStartDate = validityStartDate;
    }

    public String getValidityEndDate() {
        return validityEndDate;
    }

    public void setValidityEndDate(String validityEndDate) {
        this.validityEndDate = validityEndDate;
    }

    @Override
    public String toString() {
        return "ConversionRate{" +
                "RateId=" + RateId +
                ", currencyFrom='" + currencyFrom + '\'' +
                ", currencyTo='" + currencyTo + '\'' +
                ", rate=" + rate +
                ", validityStartDate='" + validityStartDate + '\'' +
                ", validityEndDate='" + validityEndDate + '\'' +
                '}';
    }
}