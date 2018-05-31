package com.frodel.services

import com.frodel.model.City
import com.frodel.repositories.CityRepository
import org.springframework.data.repository.PagingAndSortingRepository
import spock.lang.Specification

class CityServiceTest extends Specification{

    CityService cityService
    CityRepository cityRepository


    void setup() {
        cityRepository = Mock()
        cityService = new CityService()
        cityService.cityRepository = cityRepository
    }

    def "check type of cityRepository"() {
        expect: "cityRepository is a Spring repository"
        cityRepository instanceof PagingAndSortingRepository
    }

    def "test delegation of save of an City to the repository"() {
        given: "a city"
        def city = Mock(City)

        when: "the city is saved"
        cityService.saveCity(city);

        then: "the save is delegated to the cityRepository"
        1 * cityRepository.save(city)
    }

    def "test delegation to find a city by its name to the repository"() {
        given: "a city name"
        String cityName = "cityName"

        when: "the city is found"
        cityService.findCityByName(cityName);

        then: "the search is delegated to the cityRepository"
        1 * cityRepository.findCityByName(cityName)
    }

}
