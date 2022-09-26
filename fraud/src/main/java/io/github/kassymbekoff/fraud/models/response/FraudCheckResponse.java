package io.github.kassymbekoff.fraud.models.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class FraudCheckResponse {
    private Boolean isFraudster;
}
