package com.frodel.model

import spock.lang.Specification
import spock.lang.Unroll

import javax.validation.Validation
import javax.validation.Validator
import javax.validation.ValidatorFactory

class CountryTest extends Specification{

    Validator validator

    void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Unroll
    void "test the validity of the name for a country"(String aName) {

        given: "a correctly initialized country with a name and cities"
        Country country = new Country(name: aName, cities : Arrays.asList(Mock(City), Mock(City)))

        expect: "The country is valid"
        validator.validate(country).empty

        where:
        aName | _
        "France"| _
        "Japon"  | _
        "Irelande"  |_
        "Australie" | _
        "france" | _
        "Iran" | _
    }

    @Unroll
    void "test the invalidity of the name for a country"(String aName) {

        given: "an incorrectly initialized country with a name and cities"
        Country country = new Country(name: aName, cities : Arrays.asList(Mock(City), Mock(City)))

        expect: "The country is invalid"
        !validator.validate(country).empty


        where:
        aName | _
        "" | _
        "ndl" | _
        null | _
        "test2" | _
        "    " | _
    }

    @Unroll
    void "test the invalidity of the country initialized with no cities"(List<City> itsCities) {

        given: "an incorrectly initialized country"
        Country country = new Country(name: "France", cities : itsCities)

        expect: "The country is invalid"
        !validator.validate(country).empty


        where:
        itsCities | _
        null | _
        Arrays.asList() | _

    }
}
