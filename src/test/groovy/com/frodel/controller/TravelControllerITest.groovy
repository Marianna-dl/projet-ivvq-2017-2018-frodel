package com.frodel.controller

import com.frodel.model.City
import com.frodel.model.Continent
import com.frodel.model.Country
import com.frodel.model.Place
import com.frodel.model.Travel
import com.frodel.repositories.TravelRepository
import com.frodel.services.InitialisationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.ContextConfiguration
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import spock.lang.Specification

@ContextConfiguration
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
class TravelControllerITest extends Specification {

    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private TravelRepository travelRepository

    @Autowired
    private InitialisationService initialisationService;


    def "test to find all travels by calling url"() {

        when: "find travel requested"
        String body = this.restTemplate.getForObject("/travels", String.class);

        then:"the result provides 2 travels"
        body.contains(initialisationService.japanTravel.name)
        body.contains(initialisationService.irelandTravel.name)
    }

    def "test to find all travels with a given name calling url"() {
        given: "a travel name"
        String name = initialisationService.japanTravelName

        when: "find travel by name requested"
        String body = this.restTemplate.getForObject("/travel/" + name, String.class);

        then:"the result provides 1 travel"
        body.contains(initialisationService.japanTravel.name)
    }
}
