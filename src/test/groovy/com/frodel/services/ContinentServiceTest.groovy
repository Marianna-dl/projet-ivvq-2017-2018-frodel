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

}
