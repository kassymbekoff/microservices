package io.github.kassymbekoff.fraud.services;

import io.github.kassymbekoff.fraud.models.FraudCheckHistory;
import io.github.kassymbekoff.fraud.repositories.FraudCheckHistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckHistoryServiceImpl implements FraudCheckHistoryService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    @Override
    public boolean isFraudulentCustomer(Integer customerId) {
        FraudCheckHistory fraudCheckHistory = FraudCheckHistory.builder()
                                                .customerId(customerId)
                                                .isFraudster(false)
                                                .createdAt(LocalDateTime.now())
                                                .build();
        fraudCheckHistoryRepository.save(fraudCheckHistory);
        return false;
    }
}
