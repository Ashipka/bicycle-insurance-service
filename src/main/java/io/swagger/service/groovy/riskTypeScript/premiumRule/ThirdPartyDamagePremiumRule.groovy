package io.swagger.service.groovy.riskTypeScript.premiumRule

import io.swagger.model.Bicycle
import io.swagger.service.groovy.BaseScriptExt
import io.swagger.service.groovy.RiskTypePremiumRule

class ThirdPartyDamagePremiumRule extends BaseScriptExt implements RiskTypePremiumRule{
    static String riskType = "THIRD_PARTY_DAMAGE"

    @Override
    double calculatePremium(Bicycle bicycle) {
        double riskBasePremium = getRiskBasePremium(riskType)
        double sumInsuredFactor = getSumInsuredFactor(bicycle)
        double riskCountFactor = getRiskCountFactor(bicycle)
        return riskBasePremium * sumInsuredFactor * riskCountFactor
    }

}
