package com.frodel.services

import com.frodel.model.Continent
import com.frodel.repositories.ContinentRepository
import org.springframework.data.repository.PagingAndSortingRepository
import spock.lang.Specification

class ContinentServiceTest extends Specification {

    ContinentService continentService
    ContinentRepository continentRepository

    void setup() {
        continentRepository = Mock()
        continentService = new ContinentService()
        continentService.continentRepository = continentRepository
    }

    def "check type of continentRepository"() {
        expect: "continentRepository is a Spring repository"
        continentRepository instanceof PagingAndSortingRepository
    }

    def "test delegation of save of a continent to the repository"() {
        given: "a city"
        def continent = Mock(Continent)

        when: "the continent is saved"
        continentService.saveContinent(continent);

        then: "the save is delegated to the continentRepository"
        1 * continentRepository.save(continent)
    }

    def "test delegation to find a continent by its name to the repository"() {
        given: "a continent name"
        String continentName = "continentName"

        when: "the continent is found"
        continentService.findContinentByName(continentName);

        then: "the search is delegated to the continentRepository"
        1 * continentRepository.findContinentByName(continentName)
    }

    def "test delegation to find a countries of continent by its name to the repository"() {
        given: "a continent name"
        String continentName = "Europe"

        when: "countries are found"
        continentService.findCountriesOfContinent(continentName);

        then: "the search is delegated to the continentRepository"
        1 * continentRepository.findContinentByName(continentName)
    }

}
