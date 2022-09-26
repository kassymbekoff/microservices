package io.github.kassymbekoff.customer.services;

import io.github.kassymbekoff.customer.models.Customer;
import io.github.kassymbekoff.customer.models.request.CustomerRegistrationRequest;
import io.github.kassymbekoff.customer.models.response.FraudCheckResponse;
import io.github.kassymbekoff.customer.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    @Override
    public void registerCustomer(CustomerRegistrationRequest registrationRequest) {
        Customer customer = Customer.builder()
                                    .firstName(registrationRequest.getFirstName())
                                    .lastName(registrationRequest.getLastName())
                                    .email(registrationRequest.getEmail())
                                    .build();
        //todo: check if email is valid
        //todo: check if email is not taken
        customerRepository.saveAndFlush(customer);
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                                        "http://localhost:8085/api/v1/fraud-checking/{customerId}",
                                        FraudCheckResponse.class,
                                        customer.getId());
        if (fraudCheckResponse.getIsFraudster()) {
            throw new IllegalStateException("fraudster");
        }

        log.info("fraud check end");
    }
}
