package com.frodel.controller

import com.frodel.services.ContinentService
import spock.lang.Specification
import spock.lang.Unroll

class ContinentControllerTest extends Specification {

    private ContinentService continentService;
    private ContinentController continentController;

    void setup() {
        continentService = Mock();
        continentController = new ContinentController(continentService: continentService)
    }

    @Unroll
    void "get a continent by calling controller"() {
        given: "a continent name"
        String continentName = "Eurasie"

        when: "get a country"
        continentController.getContinent(continentName)

        then: "the recover name is good"
        1 * continentService.findContinentByName(continentName)
    }

    def "get a countries of a continent by calling controller"() {
        given: "a continent name"
        String continentName = "Europe"

        when: "get countries"
        continentController.findCountriesOfContinent(continentName)

        then: "the search is delegated to the continentService"
        1 * continentService.findCountriesOfContinent(continentName)
    }

    def "test to find all continents by calling controller"() {

        when: "requesting for all continents"
        continentController.findAllContinents()

        then: "the request is performed"
        1 * continentService.findAllContinents()
    }
}
