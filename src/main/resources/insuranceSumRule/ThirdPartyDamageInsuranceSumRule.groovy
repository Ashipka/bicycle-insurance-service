package insuranceSumRule

import io.swagger.model.Bicycle
import io.swagger.BaseScriptExt
import io.swagger.RiskTypeInsuranceSumRule

class ThirdPartyDamageInsuranceSumRule extends BaseScriptExt implements RiskTypeInsuranceSumRule {


    public static final int THIRD_PARTY_DAMAGE_INSURANCE_SUM = 100

    @Override
    double calculateInsuranceSum(Bicycle bicycle) {
        return THIRD_PARTY_DAMAGE_INSURANCE_SUM
    }
}
