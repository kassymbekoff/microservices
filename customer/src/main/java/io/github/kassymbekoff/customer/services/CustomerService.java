package io.github.kassymbekoff.customer.services;

import io.github.kassymbekoff.customer.models.request.CustomerRegistrationRequest;

public interface CustomerService {
    void registerCustomer(CustomerRegistrationRequest registrationRequest);
}
