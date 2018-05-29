package com.frodel.controller

import com.frodel.controller.TravelController
import com.frodel.model.Travel
import com.frodel.repositories.TravelRepository
import com.frodel.services.TravelService
import com.frodel.services.UserService
import spock.lang.Specification
import spock.lang.Unroll

class TravelControllerTest extends Specification {

    private TravelService travelService
    private TravelController travelController
    private UserService userService;

    void setup() {
        travelService = Mock();
        userService = Mock();
        travelController = new TravelController(travelService: travelService, userService: userService)
    }

    @Unroll
    void "add a travel by calling controller"() {
        when: "adding a travel"
        travelController.addTravel("A travel", "1")

        then: "the request is performed"
        1 * travelService.saveTravel(_)
    }

    def "test to find all travels by calling controller"() {

        when: "requesting for all travels"
        travelController.findAllTravels()

        then: "the request is performed"
        1 * travelService.findAllTravels()
    }

}
