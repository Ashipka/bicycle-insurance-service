package io.swagger.service;

import io.swagger.model.CalculateBody;
import io.swagger.model.PremiumResponse;

public interface PremiumResponseFactory {
    PremiumResponse create(CalculateBody body);
}
