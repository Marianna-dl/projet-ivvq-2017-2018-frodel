package com.frodel.controller

import com.frodel.model.Place
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

    def "test to find all travels by calling controller"() {

        when: "requesting for all travels"
        travelController.findAllTravels()

        then: "the request is performed"
        1 * travelService.findAllTravels()
    }

    def "test to find all travel with a given name by calling controller"() {

        when: "requesting for all travels with the given name"
        travelController.findAllTravelsByName("Japan")

        then: "the request is performed"
        1 * travelService.findTravelByName("Japan")
    }

    def "test to find a travel with a given id by calling controller"() {

        when: "requesting for a travel with the given id"
        travelController.findTravelById(1)

        then: "the request is performed"
        1 * travelService.findTravelById(1)
    }

}
