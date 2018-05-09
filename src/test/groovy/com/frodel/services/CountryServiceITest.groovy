package com.frodel.services

import com.frodel.TravexApplication
import com.frodel.model.City
import com.frodel.model.Country
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import javax.validation.ConstraintViolationException

@ContextConfiguration
@SpringBootTest(classes = TravexApplication.class ,webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
class CountryServiceITest extends Specification{

    @Autowired
    CountryService countryService

    def "test save a valid country"() {
        given: "a valid country"
        City city = new City(name : "Toulouse")
        Country country = new Country(name: "France", cities: Arrays.asList(city))

        when: "the country is saved"
        countryService.saveCountry(country)

        then: "the country has an id"
        country.id != null

        and: "the city has an id"
        city.id != null
    }

    def "test save an invalid country"() {
        given: "an invalid country"
        Country country = new Country(name: "", cities: Arrays.asList())

        when: "the country is saved"
        countryService.saveCountry(country)

        then: "an exception is thrown"
        thrown ConstraintViolationException

        and: "the country has still null id"
        country.id == null

    }
}
