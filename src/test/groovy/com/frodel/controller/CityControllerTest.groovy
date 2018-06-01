package com.frodel.controller

import com.frodel.services.CityService
import spock.lang.Specification

/**
 * Created by leafo on 29/05/2018.
 */
class CityControllerTest extends Specification {

    private CityService cityService;
    private CityController cityController;

    void setup()
    {
        cityService = Mock();
        cityController = new CityController(cityService : cityService);
    }

    void "get a city by calling controller"() {
        given: "a city name"
        String cityName = "name"

        when: "get a country"
        cityController.findCityByName(cityName)

        then: "the recover name is good"
        1 * cityService.findCityByName(cityName)
    }

    def "test to find all cities by calling controller"() {

        when: "requesting for all cities"
        cityController.findAllCities()

        then: "the request is performed"
        1 * cityService.findAllCities()
    }
}
