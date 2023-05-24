package io.swagger.service.groovy

import io.swagger.BaseScriptExt
import io.swagger.model.Bicycle
import spock.lang.Specification

class BaseScriptSpec extends Specification {

    def "Test getRiskBasePremium for risk type"() {
        given:
        BaseScriptExt baseScript = new BaseScriptExt()

        when:
        double premium = baseScript.getRiskBasePremium(riskType)

        then:
        premium == expectedPremium

        where:
        riskType        | expectedPremium
        "DAMAGE"        | 10
        "THIRD_PARTY_DAMAGE" | 20
        "THEFT"         | 30
    }

    def "Test getSumInsuredFactor for sum insured"() {
        given:
        BaseScriptExt baseScript = new BaseScriptExt()
        Bicycle bicycle = new Bicycle(make: "Canyon", model: "CF 5", sumInsured: sumInsured, manufactureYear: 2015)

        when:
        double factor = baseScript.getSumInsuredFactor(bicycle)

        then:
        factor == expectedFactor

        where:
        sumInsured      | expectedFactor
        500             | 0.7666666667
        1500            | 1.5333333333
        3500            | 2.5333333333
    }

    def "Test getAgeFactor for manufacture year"() {
        given:
        BaseScriptExt baseScript = new BaseScriptExt()
        Bicycle bicycle = new Bicycle(make: "Canyon", model: "CF 5", manufactureYear: manufactureYear)

        when:
        double factor = baseScript.getAgeFactor(bicycle)

        then:
        factor == expectedFactor

        where:
        manufactureYear | expectedFactor
        2010            | 1.0733333333
        2015            | 1.3066666667
        2020            | 1.6
    }

    def "Test getRiskCountFactor for number of risks"() {
        given:
        BaseScriptExt baseScript = new BaseScriptExt()
        Bicycle bicycle = new Bicycle(make: "Canyon", model: "CF 5", risks:  [''] * riskCount, manufactureYear: 2010)

        when:
        double factor = baseScript.getRiskCountFactor(bicycle)

        then:
        factor == expectedFactor

        where:
        riskCount   | expectedFactor
        0           | 1.3
        2           | 1.2
        5           | 1.0
    }
}
