package com.frodel.model

import com.frodel.model.Continent
import com.frodel.model.Country
import spock.lang.Specification
import spock.lang.Unroll

import javax.validation.Validation
import javax.validation.Validator
import javax.validation.ValidatorFactory
import java.lang.reflect.Array

class ContinentTest extends Specification{

    Validator validator

    void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Unroll
    void "test the validity of the name for the continent"(String aName) {

        given: "a correctly initialized continent with its countries and its name"
        Continent continent = new Continent(name: aName, countries: Arrays.asList(Mock(Country), Mock(Country)))

        expect: "The continent is valid"
        validator.validate(continent).empty

        where:
        aName | _
        "Europe" | _
        "Amerique du sud" | _
        "Asie" | _
    }


    @Unroll
    void "test the invalidity of the name for the continent"(String aName) {

        given: "a incorrectly initialized continent with its countries and its name"
        Continent continent = new Continent(name: aName, countries: Arrays.asList(Mock(Country), Mock(Country)))

        expect: "The continent is valid"
        !validator.validate(continent).empty

        where:
        aName | _
        "Europe1" | _
        "ab" | _
        null | _
    }


    @Unroll
    void "test the invalidity of the continent initialized with no countries"(List<Country> itsCountries) {

        given: "an incorrectly initialized continent"
        Continent continent = new Continent(name: "Europe", countries : itsCountries)

        expect: "The continent is invalid"
        !validator.validate(continent).empty


        where:
        itsCountries | _
        null | _
        Arrays.asList() | _

    }
}
