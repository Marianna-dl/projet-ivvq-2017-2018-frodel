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

    @Unroll
    void "get a country by calling controller"() {
        given: "a country name"
        String countryName = "name"

        when: "get a country"
        countryController.findCountryByName(countryName)

        then: "the recover name is good"
        1 * countryService.findCountryByName(countryName)
    }
}
