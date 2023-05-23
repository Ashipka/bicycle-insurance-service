package io.swagger.service.groovy.riskTypeScript.premiumRule

import io.swagger.model.Bicycle
import io.swagger.service.groovy.BaseScriptExt
import io.swagger.service.groovy.RiskTypePremiumRule

class DamagePremiumRule extends BaseScriptExt implements RiskTypePremiumRule{
    static String riskType = "DAMAGE"

    @Override
    double calculatePremium(Bicycle bicycle) {
        double riskBasePremium = getRiskBasePremium(riskType)
        double sumInsuredFactor = getSumInsuredFactor(bicycle)
        double bicycleAgeFactor = getAgeFactor(bicycle)
        return riskBasePremium * sumInsuredFactor * bicycleAgeFactor;
    }


 }
