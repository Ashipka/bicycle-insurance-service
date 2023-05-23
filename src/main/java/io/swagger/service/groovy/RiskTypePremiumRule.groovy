package io.swagger.service.groovy

import io.swagger.model.Bicycle

interface RiskTypePremiumRule {
    double calculatePremium(Bicycle bicycle)
}
