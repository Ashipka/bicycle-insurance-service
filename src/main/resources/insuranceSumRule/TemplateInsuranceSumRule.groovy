package insuranceSumRule

import io.swagger.BaseScriptExt
import io.swagger.RiskTypeInsuranceSumRule
import io.swagger.model.Bicycle


class TemplateInsuranceSumRule extends BaseScriptExt implements RiskTypeInsuranceSumRule {

    @Override
    double calculateInsuranceSum(Bicycle bicycle) {
        return 0;
    }
}
