package com.frodel.services

import com.frodel.TravexApplication
import com.frodel.model.City
import com.frodel.model.Continent
import com.frodel.model.Country
import com.frodel.repositories.ContinentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import javax.validation.ConstraintViolationException

@ContextConfiguration
@SpringBootTest(classes = TravexApplication.class ,webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
class ContinentServiceITest extends Specification{

    @Autowired
    ContinentService continentService

    @Autowired
    ContinentRepository continentRepository

    def "test save a valid continent"() {
        given: "a valid continent"
        Country country = new Country(name: "FranceCountry", cities: Arrays.asList(new City(name : "Toulouse")))
        Continent continent = new Continent(name:"EuropeContinent", countries: Arrays.asList(country))

        when: "the continent is saved"
        continentService.saveContinent(continent)

        then: "the continent has an id"
        continent.id != null

        and: "the country has an id"
        country.id != null

        cleanup:
        continentRepository.delete(continent.id)

        and: "france has no id"
        country.id == null

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

    def "test that continent have unique names"() {
        given: "an valid country name and two countries"
        City city = new City(name : "Toulouse")
        Country country = new Country(name: "PaysImaginaire", cities: Arrays.asList(city))
        Continent continent1 = new Continent(name: "continentTest", countries: Arrays.asList(country))
        Continent continent2 = new Continent(name: "continentTest", countries: Arrays.asList(country))

        when: "the two continent are saved"
        continentService.saveContinent(continent1)
        continentService.saveContinent(continent2)

        then: "the second continent save must throw an exception"
        thrown DataIntegrityViolationException

        then: "the continent1 has an id"
        continent1.id != null

        and: "the continent2 doesn't have an id"
        continent2.id == null

        cleanup :
        continentRepository.delete(continent1.id)
    }


}
