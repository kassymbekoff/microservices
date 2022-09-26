package io.github.kassymbekoff.customer.services;

import io.github.kassymbekoff.customer.models.Customer;
import io.github.kassymbekoff.customer.models.request.CustomerRegistrationRequest;
import io.github.kassymbekoff.customer.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public void registerCustomer(CustomerRegistrationRequest registrationRequest) {
        Customer customer = Customer.builder()
                                    .firstName(registrationRequest.getFirstName())
                                    .lastName(registrationRequest.getLastName())
                                    .email(registrationRequest.getEmail())
                                    .build();
        //todo: check if email is valid
        //todo: check if email is not taken
        customerRepository.save(customer);
    }
}
