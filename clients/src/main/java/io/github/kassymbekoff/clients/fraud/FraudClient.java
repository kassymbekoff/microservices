package io.github.kassymbekoff.clients.fraud;

import io.github.kassymbekoff.clients.fraud.models.FraudCheckResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("fraud")
public interface FraudClient {

    @GetMapping(path = "api/v1/fraud-checking/{customerId}")
    FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId);
}
