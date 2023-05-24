package insuranceSumRule

import io.swagger.model.Bicycle
import io.swagger.BaseScriptExt
import io.swagger.RiskTypeInsuranceSumRule

class TheftInsuranceSumRule extends BaseScriptExt implements RiskTypeInsuranceSumRule {

    @Override
    double calculateInsuranceSum(Bicycle bicycle) {
        return bicycle.getSumInsured()
    }
}
