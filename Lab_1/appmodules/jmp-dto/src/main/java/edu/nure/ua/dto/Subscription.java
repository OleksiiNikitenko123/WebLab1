package edu.nure.ua.dto;

import java.time.LocalDate;

public class Subscription {
    private String bankcard;
    private LocalDate predictable;

    public Subscription(String bankcard, LocalDate predictable) {
        this.bankcard = bankcard;
        this.predictable = predictable;
    }

    public String getBankcard() { return bankcard; }
    public void setBankcard(String bankcard) { this.bankcard = bankcard; }
    public LocalDate getPredictable() { return predictable; }
    public void setPredictable(LocalDate predictable) { this.predictable = predictable; }

    @Override
    public String toString() {
        return "Information about card ->>> { bankcard='" + bankcard + "', predictable=" + predictable + "}";
    }
}
