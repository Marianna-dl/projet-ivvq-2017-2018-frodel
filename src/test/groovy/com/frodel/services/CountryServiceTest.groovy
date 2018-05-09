package com.frodel.services

import com.frodel.model.Country
import com.frodel.repositories.CountryRepository
import org.springframework.data.repository.PagingAndSortingRepository
import spock.lang.Specification

class CountryServiceTest extends Specification{
    CountryService countryService
    CountryRepository countryRepository


    void setup() {
        countryRepository = Mock()
        countryService = new CountryService()
        countryService.countryRepository = countryRepository
    }

    def "check type of countryRepository"() {
        expect: "countryRepository is a Spring repository"
        countryRepository instanceof PagingAndSortingRepository
    }

    def "test delegation of save of a country to the repository"() {
        given: "a country"
        def country = Mock(Country)

        when: "the country is saved"
        countryService.saveCountry(country);

        then: "the save is delegated to the countryRepository"
        1 * countryRepository.save(country)
    }
}
