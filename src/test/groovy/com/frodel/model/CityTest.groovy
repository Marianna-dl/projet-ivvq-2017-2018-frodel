package com.frodel.model

import com.frodel.model.City
import spock.lang.Specification
import spock.lang.Unroll

import javax.validation.Validation
import javax.validation.Validator
import javax.validation.ValidatorFactory

class CityTest extends Specification{

    Validator validator

    void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Unroll
    void "test if a city is correct"(String aName) {

        given: "a correctly initialized city"
        City city = new City(name: aName)

        expect: "The city is valid"
        validator.validate(city).empty

        where:
        aName | _
        "Paris" | _
        "Toulouse" | _
        "Mo" | _
        "Tokyo" | _
        "tokyo" | _
    }

    @Unroll
    void "test if a city is incorrect"(String aName) {

        given: "an incorrectly initialized city"
        City city = new City(name: aName)

        expect: "The city is invalid"
        !validator.validate(city).empty

        where:
        aName | _
        "" | _
        "t" | _
        null | _
        "t2" | _
        "   " | _
    }
}
