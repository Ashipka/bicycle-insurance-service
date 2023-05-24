package premiumRule

import io.swagger.model.Bicycle
import io.swagger.BaseScriptExt
import io.swagger.RiskTypePremiumRule

class TheftPremiumRule extends BaseScriptExt implements RiskTypePremiumRule{
    static String riskType = "THEFT"

    @Override
    double calculatePremium(Bicycle bicycle) {
        double riskBasePremium = getRiskBasePremium(riskType)
        double sumInsuredFactor = getSumInsuredFactor(bicycle)
        return riskBasePremium * sumInsuredFactor;
    }

}
