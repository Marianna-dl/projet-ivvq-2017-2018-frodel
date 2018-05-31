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

}