package com.frodel.services

import com.frodel.Bootstrap
import com.frodel.TravexApplication
import com.frodel.model.Article
import com.frodel.model.City
import com.frodel.model.Country
import com.frodel.repositories.CountryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import javax.transaction.Transactional
import javax.validation.ConstraintViolationException

@ContextConfiguration
@SpringBootTest(classes = TravexApplication.class ,webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
class CountryServiceITest extends Specification{

    @Autowired
    CountryService countryService
    @Autowired
    Bootstrap bootstrap

    @Autowired
    CountryRepository countryRepository

    def "test save a valid country"() {
        given: "a valid country"
        City city = new City(name : "Toulouse")
        Country country = new Country(name: "PaysImaginaire", cities: Arrays.asList(city))

        when: "the country is saved"
        countryService.saveCountry(country)

        then: "the country has an id"
        country.id != null

        and: "the city has an id"
        city.id != null

        cleanup :
        countryRepository.delete(country.id)
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

    def "test find a valid country by its name"() {
        given: "an valid country name"
        String countryName = "Japon"

        when: "the country is find"
        Country country = countryService.findCountryByName(countryName)

        then: "the country has an id"
        country.id != null

        and: "the country has a name"
        country.name == countryName
    }

    def "test that countries have unique names"() {
        given: "an valid country name and two countries"
        City city = new City(name : "Toulouse")
        Country country1 = new Country(name: "PaysImaginaire", cities: Arrays.asList(city))
        Country country2 = new Country(name: "PaysImaginaire", cities: Arrays.asList(city))

        when: "the two countries are saved"
        countryService.saveCountry(country1)
        countryService.saveCountry(country2)

        then: "the second country save must throw an exception"
        thrown DataIntegrityViolationException

        then: "the country1 has an id"
        country1.id != null

        and: "the country2 doesn't have an id"
        country2.id == null
    }

    def "test find cities by country name"() {
        given: "The instance of InitialisationService provided by the bootstrap object"
        InitialisationService initialisationService = bootstrap.initialisationService

        and: "an valid country name"
        String countryName = "France"

        when: "cities are found"
        List<City> cities = countryService.findCitiesOfCountry(countryName)

        then: "city list is not null"
        cities != null

        and: "the country has a name"
        cities[0].id == initialisationService.toulouse.id
        cities[1].id == initialisationService.paris.id
    }

    def "test getting all countries"() {
        given: "The instance number of countries in the bootstrap object"
        int countryNumber = 4

        when: "requesting all articles"
        Iterable<Country> countries = countryService.findAllCountries()

        then : "the articles are the same given by the initialisation service"
        countries.size() >= countryNumber
    }
}
