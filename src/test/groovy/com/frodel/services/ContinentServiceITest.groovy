package com.frodel.services

import com.frodel.Bootstrap
import com.frodel.TravexApplication
import com.frodel.model.Article
import com.frodel.model.City
import com.frodel.model.Continent
import com.frodel.model.Country
import com.frodel.repositories.ContinentRepository
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
class ContinentServiceITest extends Specification{

    @Autowired
    ContinentService continentService

    @Autowired
    ContinentRepository continentRepository

    @Autowired
    Bootstrap bootstrap

    def "test save a valid continent"() {
        given: "a valid continent"
        Country country = new Country(name: "FranceCountry", cities: Arrays.asList(new City(name : "Toulouse")))
        Continent continent = new Continent(name:"EuropeContinentTest", countries: Arrays.asList(country))

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

    def "test find a valid continent by its name"() {
        given: "an valid continent name"
        String continentName = "Europe"

        when: "the continent is find"
        Continent continent = continentService.findContinentByName(continentName)

        then: "the continent has an id"
        continent.id != null

        and: "the continent has a name"
        continent.name == continentName
    }

    def "test find countries by continent name"() {
        given: "The instance of InitialisationService provided by the bootstrap object"
        InitialisationService initialisationService = bootstrap.initialisationService

        and: "an valid continent name"
        String continentName = "Europe"

        when: "countries are found"
        List<Country> countries = continentService.findCountriesOfContinent(continentName)

        then: "country list is not null"
        countries != null

        and: "countries has an id"
        countries[0].id == initialisationService.ireland.id
        countries[1].id == initialisationService.france.id
        countries[2].id == initialisationService.espagne.id

        and: "countries has a name"
        countries[0].name == initialisationService.ireland.name
        countries[1].name == initialisationService.france.name
        countries[2].name == initialisationService.espagne.name

        and: "countries has cities"
        countries[0].cities.size() == initialisationService.ireland.cities.size()
        countries[1].cities.size() == initialisationService.france.cities.size()
        countries[2].cities.size() == initialisationService.espagne.cities.size()
    }

    def "test getting all continents"() {
        given: "2 continents provided by the initialisation service"
        InitialisationService initialisationService = bootstrap.initialisationService
        initialisationService.europe
        initialisationService.asie

        when: "requesting all continent"
        Iterable<Continent> continents = continentService.findAllContinents()

        then : "continent are the same given by the initialisation service"
        continents[0].id == initialisationService.asie.id
        continents[1].id == initialisationService.europe.id

        continents[0].name == initialisationService.asie.name
        continents[1].name == initialisationService.europe.name

        continents[0].countries.size() == initialisationService.asie.countries.size()
        continents[1].countries.size() == initialisationService.europe.countries.size()
    }

}
