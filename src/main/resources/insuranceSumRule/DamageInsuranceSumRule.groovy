package insuranceSumRule

import io.swagger.BaseScriptExt
import io.swagger.RiskTypeInsuranceSumRule
import io.swagger.model.Bicycle

class DamageInsuranceSumRule extends BaseScriptExt implements RiskTypeInsuranceSumRule {

    @Override
    double calculateInsuranceSum(Bicycle bicycle) {
        return bicycle.getSumInsured() / 2
    }
}
