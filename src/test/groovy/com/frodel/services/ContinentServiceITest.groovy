package com.frodel.services

import com.frodel.TravexApplication
import com.frodel.model.City
import com.frodel.model.Continent
import com.frodel.model.Country
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import javax.validation.ConstraintViolationException

@ContextConfiguration
@SpringBootTest(classes = TravexApplication.class ,webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
class ContinentServiceITest extends Specification{

    @Autowired
    ContinentService continentService

    def "test save a valid continent"() {
        given: "a valid continent"
        Country country = new Country(name: "France", cities: Arrays.asList(new City(name : "Toulouse")))
        Continent continent = new Continent(name:"Europe", countries: Arrays.asList(country))

        when: "the continent is saved"
        continentService.saveContinent(continent)

        then: "the continent has an id"
        continent.id != null

        and: "the country has an id"
        country.id != null

    }

    def "test save an invalid continent"() {
        given: "an invalid continent"
        Continent continent = new Continent(name:"Europe")

        when: "the continent is saved"
        continentService.saveContinent(continent)

        then: "an exception is thrown"
        thrown ConstraintViolationException

        and: "the continent has still null id"
        continent.id == null

    }


}
