package io.swagger

import io.swagger.model.Bicycle
import org.springframework.core.io.Resource
import org.springframework.core.io.support.PathMatchingResourcePatternResolver
import org.springframework.util.StreamUtils

import java.lang.reflect.Constructor

class RuleEngine {
    public static final String INSURANCE_SUM_SCRIPT_FOLDER = "insuranceSumRule/*"
    public static final String PREMIUM_SCRIPT_FOLDER = "premiumRule/*"

    private Map<String, RiskTypeInsuranceSumRule> insuranceSumRules = [:]
    private Map<String, RiskTypePremiumRule> premiumRules = [:]

    RuleEngine() {
        initializeRules()
    }

    private void initializeRules() {
        loadInsuranceSumRules()
        loadPremiumRules()
    }

    double calculateInsuranceSum(String riskType, Bicycle bicycle) {
        RiskTypeInsuranceSumRule rule = insuranceSumRules[getNormalizedRiskType(riskType)]
        if (rule) {
            return rule.calculateInsuranceSum(bicycle)
        }
        throw new IllegalArgumentException("Unsupported risk type: $riskType")
    }

    double calculatePremium(String riskType, Bicycle bicycle) {
        RiskTypePremiumRule rule = premiumRules[getNormalizedRiskType(riskType)]
        if (rule) {
            return rule.calculatePremium(bicycle)
        }
        throw new IllegalArgumentException("Unsupported risk type: $riskType")
    }

    void loadInsuranceSumRules() {
        PathMatchingResourcePatternResolver scanner = new PathMatchingResourcePatternResolver();
        Resource[] resources = scanner.getResources(INSURANCE_SUM_SCRIPT_FOLDER)
        resources.each { resource ->
            {
                def insuranceSumScript = readFileBody(resource);
                GroovyClassLoader groovyClassLoader = new GroovyClassLoader()
                Class<RiskTypeInsuranceSumRule> insuranceSumScriptClass = groovyClassLoader.parseClass(insuranceSumScript)
                Constructor<?> constructor = insuranceSumScriptClass.getDeclaredConstructor()
                RiskTypeInsuranceSumRule insuranceSumRule = constructor.newInstance()
                String normalizedRiskType = getNormalizedRiskType(resource.getFilename())
                insuranceSumRules[normalizedRiskType] = insuranceSumRule
            }
        }
    }

    void loadPremiumRules() {
        PathMatchingResourcePatternResolver scanner = new PathMatchingResourcePatternResolver();
        Resource[] resources = scanner.getResources(PREMIUM_SCRIPT_FOLDER)
        resources.each { resource ->
            {
                def premiumScript = readFileBody(resource);
                GroovyClassLoader groovyClassLoader = new GroovyClassLoader()
                Class<RiskTypePremiumRule> premiumScriptClass = groovyClassLoader.parseClass(premiumScript)
                Constructor<?> constructor = premiumScriptClass.getDeclaredConstructor()
                RiskTypePremiumRule premiumRule = constructor.newInstance()
                String normalizedRiskType = getNormalizedRiskType(resource.getFilename())
                premiumRules[normalizedRiskType] = premiumRule
            }
        }
    }

    private static String readFileBody(Resource resource) {
        try {
            byte[] bytes = StreamUtils.copyToByteArray(resource.inputStream)
            return new String(bytes, "UTF-8")
        } catch (IOException e) {
            // Handle the exception appropriately
            println "Error reading file: ${e.message}"
            return ""  // Return an empty string as a fallback
        }
    }

    String getNormalizedRiskType(String fileName) {
        return fileName
                .replace("InsuranceSumRule.groovy", "")
                .replace("PremiumRule.groovy", "")
                .replaceAll("[^a-zA-Z]", "")
                .toUpperCase();
    }


}
