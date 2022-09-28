package io.github.kassymbekoff.customer.services;

import io.github.kassymbekoff.clients.fraud.FraudClient;
import io.github.kassymbekoff.clients.fraud.models.FraudCheckResponse;
import io.github.kassymbekoff.clients.notification.NotificationClient;
import io.github.kassymbekoff.clients.notification.models.NotificationRequest;
import io.github.kassymbekoff.customer.models.Customer;
import io.github.kassymbekoff.customer.models.request.CustomerRegistrationRequest;
import io.github.kassymbekoff.customer.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;

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

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());
        if (fraudCheckResponse.getIsFraudster()) {
            throw new IllegalStateException("fraudster");
        }
        log.info("fraud check end");

        NotificationRequest notificationRequest =
                new NotificationRequest(customer.getId(), customer.getEmail(), "HeLLo from customer");

        notificationClient.sendNotification(notificationRequest);
        log.info("notification sent");

    }
}
