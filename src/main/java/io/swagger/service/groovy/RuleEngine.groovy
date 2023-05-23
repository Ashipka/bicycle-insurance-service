package io.swagger.service.groovy


import io.swagger.model.Bicycle

import java.lang.reflect.Constructor

class RuleEngine {
    public static final String INSURANCE_SUM_SCRIPT_FOLDER = "src/main/java/io/swagger/service/groovy/riskTypeScript/insuranceSumRule"
    public static final String PREMIUM_SCRIPT_FOLDER = "src/main/java/io/swagger/service/groovy/riskTypeScript/premiumRule"

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
        def insuranceSumScriptFolder = new File(INSURANCE_SUM_SCRIPT_FOLDER)
        def insuranceSumScripts = insuranceSumScriptFolder.listFiles(new FilenameFilter() {
            boolean accept(File dir, String name) {
                return name.endsWith(".groovy")
            }
        })
        insuranceSumScripts.each {insuranceSumScript ->
            GroovyClassLoader groovyClassLoader = new GroovyClassLoader()
            Class<RiskTypeInsuranceSumRule> insuranceSumScriptClass = groovyClassLoader.parseClass(insuranceSumScript)
            Constructor<?> constructor = insuranceSumScriptClass.getDeclaredConstructor()
            RiskTypeInsuranceSumRule insuranceSumRule =  constructor.newInstance()
            String normalizedRiskType = getNormalizedRiskType(insuranceSumScript.name)
            insuranceSumRules[normalizedRiskType] = insuranceSumRule
        }
    }

    void loadPremiumRules() {
        def premiumScriptFolder = new File(PREMIUM_SCRIPT_FOLDER)
        def premiumScripts = premiumScriptFolder.listFiles(new FilenameFilter() {
            boolean accept(File dir, String name) {
                return name.endsWith(".groovy")
            }
        })
        premiumScripts.each {premiumScript ->
            GroovyClassLoader groovyClassLoader = new GroovyClassLoader()
            Class<RiskTypePremiumRule> premiumScriptClass = groovyClassLoader.parseClass(premiumScript)
            Constructor<?> constructor = premiumScriptClass.getDeclaredConstructor()
            RiskTypePremiumRule premiumRule =  constructor.newInstance()
            String normalizedRiskType = getNormalizedRiskType(premiumScript.name)
            premiumRules[normalizedRiskType] = premiumRule
        }
    }

    String getNormalizedRiskType(String fileName) {
        return fileName
                .replace("InsuranceSumRule.groovy","")
                .replace("PremiumRule.groovy","")
                .replaceAll("[^a-zA-Z]", "")
                .toUpperCase();
    }
}
