package premiumRule

import io.swagger.model.Bicycle
import io.swagger.BaseScriptExt
import io.swagger.RiskTypePremiumRule

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
