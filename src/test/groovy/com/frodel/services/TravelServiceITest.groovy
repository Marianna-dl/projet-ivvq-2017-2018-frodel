package com.frodel.services

import com.frodel.TravexApplication
import com.frodel.model.Travel
import com.frodel.services.TravelService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 * Created by Marianna on 27/04/2018.
 */
@ContextConfiguration
@SpringBootTest(classes = TravexApplication.class ,webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
class TravelServiceITest extends Specification{

    @Autowired TravelService travelService


    def "test save a valid travel"() {
        given: "a valid travel"
        Travel travel = new Travel(name: "Mon voyage au Japon" )

        when: "the travel is saved"
        travelService.saveTravel(travel);

        then: "the travel has an id"
        travel.id != null

    }




}
