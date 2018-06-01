package com.frodel.controller

import com.frodel.services.CountryService
import spock.lang.Specification
import spock.lang.Unroll

class CountryControllerTest extends Specification {

    private CountryService countryService;
    private CountryController countryController

    void setup() {
        countryService = Mock();
        countryController = new CountryController(countryService: countryService)
    }

    def "get a country by calling controller"() {
        given: "a country name"
        String countryName = "name"

        when: "get a country"
        countryController.findCountryByName(countryName)

        then: "the search is delegated to the countryService"
        1 * countryService.findCountryByName(countryName)
    }

    def "get a cities of a country by calling controller"() {
        given: "a country name"
        String countryName = "name"

        when: "get cities"
        countryController.findCitiesOfCountry(countryName)

        then: "the search is delegated to the countryService"
        1 * countryService.findCitiesOfCountry(countryName)
    }

    def "test to find all countries by calling controller"() {

        when: "requesting for all countries"
        countryController.findAllCountries()

        then: "the request is performed"
        1 * countryService.findAllCountries()
    }
}
