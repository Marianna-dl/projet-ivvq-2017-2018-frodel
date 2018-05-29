package com.frodel.services

import com.frodel.TravexApplication
import com.frodel.model.City
import com.frodel.model.Continent
import com.frodel.model.Country
import com.frodel.model.Place
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import javax.validation.ConstraintViolationException

@ContextConfiguration
@SpringBootTest(classes = TravexApplication.class ,webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
class PlaceServiceITest extends Specification {

    @Autowired
    PlaceService placeService
    @Autowired
    ContinentService continentService

    def "test save a valid place"() {
        given: "a valid place initialized with a previously saved continent"

        City toulouseCity = new City(name : "Toulouse")
        City parisCity = new City(name : "Paris")
        Country franceCountry = new Country(name : "France", cities : Arrays.asList(toulouseCity, parisCity));


        City romeCity = new City(name : "Rome")
        City veniseCity = new City(name : "Venise")
        Country italieCountry = new Country(name : "Italie",cities : Arrays.asList(romeCity, veniseCity));

        Continent continent = new Continent(name : "Europe", countries : Arrays.asList(franceCountry, italieCountry))

        continentService.saveContinent(continent)

        Place place = new Place(continent : continent, country : franceCountry, city : parisCity);

        when: "the place is saved"
        placeService.savePlace(place)

        then: "the place has an id"
        place.id != null

    }

    def "test save an invalid place"() {
        given: "an invalid place"
        Place place = new Place(continent : null, country : null, city : null);

        when: "the place is saved"
        placeService.savePlace(place)

        then: "an exception is thrown"
        thrown ConstraintViolationException

        and: "the place has still null id"
        place.id == null

    }


}
