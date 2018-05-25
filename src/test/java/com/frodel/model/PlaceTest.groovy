package com.frodel.model

import spock.lang.Specification
import spock.lang.Unroll

import javax.validation.Validation
import javax.validation.Validator
import javax.validation.ValidatorFactory

class PlaceTest extends Specification{

    Validator validator

    void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Unroll
    void "test the validity of a place"() {

        given: "a correctly initialized place with a continent, a country and a city"
        Place place = new Place(continent: Mock(Continent), country: Mock(Country), city:Mock(City));

        expect: "The place is valid"
        validator.validate(place).empty
    }

    @Unroll
    void "test the invalidity of a place"(Continent aContinent, Country aCountry, City aCity) {

        given: "an incorrectly initialized place without a continent, a country or a city"
        Place place = new Place(continent: aContinent, country: aCountry, city:aCity);

        expect: "The place is invalid"
        !validator.validate(place).empty

        where:
        aContinent | aCountry | aCity
        null | Mock(Country) | Mock(City)
        Mock(Continent) | null | Mock(City)
        Mock(Continent) | Mock(Country) | null
        null | null | null
    }

}
