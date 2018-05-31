package com.frodel.controller

import com.frodel.model.City
import com.frodel.services.InitialisationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 * Created by leafo on 29/05/2018.
 */
@ContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CityControllerITest extends Specification {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private InitialisationService initialisationService;

    void "get a city by calling url"() {
        when: "get a city requested"
        City city = this.restTemplate.getForObject("/city/Madrid", City.class)

        then: "the recover city name is the same that the recover city name of initialisationService"
        city.id == initialisationService.madrid.id

        and:
        city.name == initialisationService.madrid.name
    }

    def "test to find all cities by calling url"() {
        given: "the number of cities"
        int numberCities = 8

        when: "find cities requested"
        Iterable<City> cities = this.restTemplate.getForObject("/cities", Iterable.class);

        then:"the result provides 8 articles"
        cities.size() >=  numberCities
    }
}
