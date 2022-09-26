package io.github.kassymbekoff.fraud.services;

public interface FraudCheckHistoryService {
    boolean isFraudulentCustomer(Integer customerId);
}
