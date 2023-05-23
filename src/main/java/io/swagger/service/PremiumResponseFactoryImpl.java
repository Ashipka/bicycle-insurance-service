package io.swagger.service;

import io.swagger.model.*;
import io.swagger.service.groovy.RuleEngine;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class PremiumResponseFactoryImpl implements PremiumResponseFactory {

    private final RuleEngine ruleEngine = new RuleEngine();

    @Override
    public PremiumResponse create(CalculateBody body) {
        List<PremiumResponseObjects> responseObjectsList = new LinkedList<>();
        double totalPremium = getTotalPremium(body, responseObjectsList);
        PremiumResponse premiumResponse = new PremiumResponse();
        premiumResponse.setObjects(responseObjectsList);
        premiumResponse.setPremium(totalPremium);
        return premiumResponse;
    }

    private double getTotalPremium(CalculateBody body, List<PremiumResponseObjects> responseObjectsList) {
        double totalPremium = 0;
        for (Bicycle bicycle : body.getBicycles()) {
            PremiumResponseObjects premiumResponseObjects = new PremiumResponseObjects();
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("MANUFACTURE_YEAR", bicycle.getManufactureYear());
            attributes.put("MODEL", bicycle.getModel());
            attributes.put("MAKE", bicycle.getMake());
            premiumResponseObjects.setAttributes(attributes);
            premiumResponseObjects.setSumInsured(bicycle.getSumInsured());
            List<PremiumResponseRisks> premiumResponseRisksList = new LinkedList<>();
            double objectPremium = getObjectPremium(bicycle, premiumResponseRisksList);
            premiumResponseObjects.setPremium(objectPremium);
            totalPremium += objectPremium;
            premiumResponseObjects.setRisks(premiumResponseRisksList);
            responseObjectsList.add(premiumResponseObjects);
        }
        return totalPremium;
    }

    private double getObjectPremium(Bicycle bicycle, List<PremiumResponseRisks> premiumResponseRisksList) {
        double objectPremium = 0;
        for (String riskType : bicycle.getRisks()) {
            PremiumResponseRisks premiumResponseRisks = new PremiumResponseRisks();
            premiumResponseRisks.setRiskType(riskType);
            double premium = ruleEngine.calculatePremium(riskType, bicycle);
            premiumResponseRisks.setPremium(premium);
            objectPremium += premium;
            double sumInsured = ruleEngine.calculateInsuranceSum(riskType, bicycle);
            premiumResponseRisks.setSumInsured(sumInsured);
            premiumResponseRisksList.add(premiumResponseRisks);
        }
        return objectPremium;
    }
}
