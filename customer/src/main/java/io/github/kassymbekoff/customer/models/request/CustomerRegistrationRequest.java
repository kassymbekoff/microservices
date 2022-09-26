package io.github.kassymbekoff.customer.models.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerRegistrationRequest {
    private String firstName;
    private String lastName;
    private String email;
}
