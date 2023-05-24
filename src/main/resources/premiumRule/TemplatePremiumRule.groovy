package premiumRule

import io.swagger.model.Bicycle
import io.swagger.BaseScriptExt
import io.swagger.RiskTypePremiumRule

class TemplatePremiumRule extends BaseScriptExt implements RiskTypePremiumRule{

    @Override
    double calculatePremium(Bicycle bicycle) {
        return 0;
    }

}
