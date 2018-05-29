package com.frodel.services

import com.frodel.TravexApplication
import com.frodel.model.City
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import javax.validation.ConstraintViolationException

@ContextConfiguration
@SpringBootTest(classes = TravexApplication.class ,webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
class CityServiceITest extends Specification{

    @Autowired CityService cityService

    def "test save a valid city"() {
        given: "a valid city"
        City city = new City(name: "Toulouse")

        when: "the city is saved"
        cityService.saveCity(city);

        then: "the city has an id"
        city.id != null

    }

    def "test save an invalid city"() {
        given: "an invalid city"
        City city = new City(name: "")

        when: "the city is saved"
        cityService.saveCity(city);

        then: "une exception est levée"
        thrown ConstraintViolationException

        and: "the city has still null id"
        city.id == null

    }

    def "test find a valid city by its name"() {
        given: "an valid city name"
        String cityName = "Madrid"

        when: "the city is find"
        City city = cityService.findCityByName(cityName)

        then: "the city has an id"
        city.id != null

        and: "the country has a name"
        city.name == cityName
    }


}
