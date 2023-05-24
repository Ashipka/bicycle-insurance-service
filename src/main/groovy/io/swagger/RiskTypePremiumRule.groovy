package io.swagger

import io.swagger.model.Bicycle

interface RiskTypePremiumRule {
    double calculatePremium(Bicycle bicycle)
}
