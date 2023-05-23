package io.swagger.service.groovy.riskTypeScript.insuranceSumRule

import io.swagger.model.Bicycle
import io.swagger.service.groovy.BaseScriptExt
import io.swagger.service.groovy.RiskTypeInsuranceSumRule

class DamageInsuranceSumRule extends BaseScriptExt implements RiskTypeInsuranceSumRule {

    @Override
    double calculateInsuranceSum(Bicycle bicycle) {
        return bicycle.getSumInsured() / 2
    }
}