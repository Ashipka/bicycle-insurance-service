package io.swagger.service.groovy

import io.swagger.model.Bicycle

import java.time.Year

class BaseScriptExt extends BaseScript {

    double getRiskBasePremium(String riskType) {
        return getRiskBasePremiumData()
                .find { it.RISK_TYPE == riskType }?.PREMIUM
    }

    double getSumInsuredFactor(Bicycle bicycle) {
        def factorMinMax = getSumInsuredFactorMinMax(bicycle.getSumInsured())
        def factorMin = factorMinMax[0]
        def factorMax = factorMinMax[1]
        def ageActual = Year.now().value - bicycle.getManufactureYear()
        return factorMax - (factorMax - factorMin) * (Bicycle.AGE_MAX - ageActual) / (Bicycle.AGE_MAX - Bicycle.AGE_MIN)
    }

    double getAgeFactor(Bicycle bicycle) {
        def factorMinMax = getAgeFactorMinMax(bicycle)
        def factorMin = factorMinMax[0]
        def factorMax = factorMinMax[1]
        def ageActual = Year.now().value - bicycle.getManufactureYear()
        return factorMax - (factorMax - factorMin) * (Bicycle.AGE_MAX - ageActual) / (Bicycle.AGE_MAX - Bicycle.AGE_MIN)
    }

    double getRiskCountFactor(Bicycle bicycle) {
        def factorMinMax = getRiskCountFactorMinMax(bicycle.getRisks().size())
        def factorMin = factorMinMax[0]
        def factorMax = factorMinMax[1]
        def ageActual = Year.now().value - bicycle.getManufactureYear()
        return factorMax - (factorMax - factorMin) * (Bicycle.AGE_MAX - ageActual) / (Bicycle.AGE_MAX - Bicycle.AGE_MIN)
    }

    def getRiskCountFactorMinMax(value) {
        def riskCountFactorData = getRiskCountFactorData()
        for (def data : riskCountFactorData) {
            def valueFrom = data['VALUE_FROM']
            def valueTo = data['VALUE_TO']
            def factorMin = data['FACTOR_MIN']
            def factorMax = data['FACTOR_MAX']
            if (value >= valueFrom && value <= valueTo) {
                return [factorMin, factorMax]
            }
        }
        throw new IllegalArgumentException("Unsupported risk count: $value")
    }

    def getSumInsuredFactorMinMax(value) {
        def sumInsuredFactorData = getSumInsuredFactorData()
        for (def data : sumInsuredFactorData) {
            def valueFrom = data['VALUE_FROM']
            def valueTo = data['VALUE_TO']
            def factorMin = data['FACTOR_MIN']
            def factorMax = data['FACTOR_MAX']
            if (value >= valueFrom && value <= valueTo) {
                return [factorMin, factorMax]
            }
        }
        throw new IllegalArgumentException("Unsupported sum insured: $value")
    }

    def getAgeFactorMinMax(Bicycle bicycle) {
        def ageFactorData = getAgeFactorData()
        def ageActual = Year.now().value - bicycle.getManufactureYear()
        for (def data : ageFactorData) {
            def make = data['MAKE']
            def model = data['MODEL']
            def valueFrom = data['VALUE_FROM']
            def valueTo = data['VALUE_TO']
            def factorMin = data['FACTOR_MIN']
            def factorMax = data['FACTOR_MAX']
            if (make == bicycle.getMake()
                    && model == bicycle.getModel()
                    && ageActual >= valueFrom
                    && ageActual <= valueTo) {
                return [factorMin, factorMax]
            }
        }

        for (def data : ageFactorData) {
            def make = data['MAKE']
            def valueFrom = data['VALUE_FROM']
            def valueTo = data['VALUE_TO']
            def factorMin = data['FACTOR_MIN']
            def factorMax = data['FACTOR_MAX']
            if (make == bicycle.getMake()
                    && ageActual >= valueFrom
                    && ageActual <= valueTo) {
                return [factorMin, factorMax]
            }
        }

        for (def data : ageFactorData) {
            def valueFrom = data['VALUE_FROM']
            def valueTo = data['VALUE_TO']
            def factorMin = data['FACTOR_MIN']
            def factorMax = data['FACTOR_MAX']
            if (ageActual >= valueFrom && ageActual <= valueTo) {
                return [factorMin, factorMax]
            }
        }
        throw new IllegalArgumentException("No age factor MIN and MAX found for: $bicycle")
    }
}
