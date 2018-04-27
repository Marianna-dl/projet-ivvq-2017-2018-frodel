package com.frodel.controller

import com.frodel.repositories.TravelRepository
import spock.lang.Specification
import spock.lang.Unroll

class TravelControllerTest extends Specification {

    private TravelRepository travelRepository
    private TravelController travelController

    void setup() {
        travelRepository = Mock();
        travelController = new TravelController(travelRepository: travelRepository)
    }

    @Unroll
    void "add a travel by calling controller"() {
        when: "adding a travel"
        travelController.addTravel("A travel")

        then:
        1 * travelRepository.save(_)
    }

}
