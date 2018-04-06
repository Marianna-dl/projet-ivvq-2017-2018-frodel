package com.frodel

import com.frodel.model.Travel
import spock.lang.Specification
import spock.lang.Unroll

import javax.validation.Validation
import javax.validation.Validator
import javax.validation.ValidatorFactory

/**
 * Created by leafo on 30/03/2018.
 */
class TravelTest extends Specification {

    Validator validator

    void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Unroll
    void "test if a travel is correct"(String aName) {

        given: "a correctly initialized travel"
        Travel travel = new Travel(name: aName)

        expect: "The travel is valid"
        validator.validate(travel).empty

        where:
        aName | _
        "Travel1" | _
        "trav" | _
        "étape" | _
    }

}
