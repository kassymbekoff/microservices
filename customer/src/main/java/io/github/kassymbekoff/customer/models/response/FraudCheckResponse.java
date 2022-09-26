package io.github.kassymbekoff.customer.models.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class FraudCheckResponse {
    private Boolean isFraudster;
}
