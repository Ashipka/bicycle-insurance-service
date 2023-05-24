package io.swagger

import io.swagger.model.Bicycle

interface RiskTypeInsuranceSumRule {
    double calculateInsuranceSum(Bicycle bicycle)
}
