package io.github.kassymbekoff.clients.fraud.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FraudCheckResponse {
    private Boolean isFraudster;
}
