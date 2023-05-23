package io.swagger.service.groovy.riskTypeScript.premiumRule

import io.swagger.model.Bicycle
import io.swagger.service.groovy.BaseScriptExt
import io.swagger.service.groovy.RiskTypePremiumRule

class TemplatePremiumRule extends BaseScriptExt implements RiskTypePremiumRule{

    @Override
    double calculatePremium(Bicycle bicycle) {
        return 0;
    }

}
