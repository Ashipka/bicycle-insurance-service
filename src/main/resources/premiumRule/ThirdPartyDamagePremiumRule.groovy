package premiumRule

import io.swagger.model.Bicycle
import io.swagger.BaseScriptExt
import io.swagger.RiskTypePremiumRule

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
