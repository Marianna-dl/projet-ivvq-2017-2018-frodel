package com.frodel.controller

import com.frodel.controller.TravelController
import com.frodel.model.Place
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

        travelController.addTravel("A travel", "1000", new Date(2018-01-01),  new Date(2018-02-01), "This travel was amazing ! But the content must have a size of 100 characters so we write some lines ...",
        Arrays.asList(Mock(Place)));

        then:
        1 * travelRepository.save(_)
    }

}
