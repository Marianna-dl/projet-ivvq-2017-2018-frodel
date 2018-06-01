package com.frodel.controller

import com.frodel.model.Article
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
        Iterable<Travel> travels = this.restTemplate.getForObject("/travels", Iterable.class);

        then:"the result provides 2 travels"
        travels.size() >= 2
    }

    def "test to find all travels with a given name calling url"() {
        given: "a travel name"
        String name = initialisationService.japanTravelName

        when: "find travel by name requested"
        Iterable<Travel> travels = this.restTemplate.getForObject("/travel/name/" + name, Iterable.class);

        then:"the result provides 1 travel"
        travels.size() >= 1
    }

    def "test to find a travel with a given id calling url"() {
        given: "a travel id"
        Long id = initialisationService.japanTravel.id

        when: "find travel by name requested"
        Travel travel = this.restTemplate.getForObject("/travel/id/" + id, Travel.class);

        then:"the result provides 1 travel"
        travel.name ==  initialisationService.japanTravel.name
    }

    def "test to find all articles of a travel with a given id calling url"() {
        given: "a travel name"
        Long id = initialisationService.japanTravel.id

        when: "find travel by name requested"
        Iterable<Article> articles = this.restTemplate.getForObject("/travel/articles/" + id, Iterable.class);

        then:"the result provides 2 articles"
        articles.size() >= 2
    }
}
