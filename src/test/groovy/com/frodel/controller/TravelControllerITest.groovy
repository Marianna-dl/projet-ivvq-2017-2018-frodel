package com.frodel.controller

import com.frodel.model.City
import com.frodel.model.Continent
import com.frodel.model.Country
import com.frodel.model.Place
import com.frodel.model.Travel
import com.frodel.repositories.TravelRepository
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
    private TravelRepository travelRepository;

    void "add a travel by calling url"(String aTravelName) {

        given : "A list of places"

        City toulouseCity = new City(name : "Toulouse")
        City parisCity = new City(name : "Paris")
        Country franceCountry = new Country(name : "France", cities : Arrays.asList(toulouseCity, parisCity));


        City romeCity = new City(name : "Rome")
        City veniseCity = new City(name : "Venise")
        Country italieCountry = new Country(name : "Italie",cities : Arrays.asList(romeCity, veniseCity));

        Continent continent = new Continent(name : "Europe", countries : Arrays.asList(franceCountry, italieCountry))

        Place place1 = new Place(continent : continent, country : franceCountry, city : parisCity);
        Place place2 = new Place(continent : continent, country : italieCountry, city : veniseCity);

        when: "add travel requested"
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, String>();
        map.add("name", aTravelName);
        map.add("travelBudget", "1000");
        map.add("travelStartDate", new Date(2018-01-01));
        map.add("travelEndDate",  new Date(2018-02-01));
        map.add("travelDescription", "This travel was amazing ! But the content must have a size of 100 characters so we write some lines ...");
        map.add("travelPlaces", Arrays.asList(place1, place2));

        Travel travel = restTemplate.postForObject("/travel", map, Travel.class)

        then: "the recover name of travel is the same that the send name"
        travel.name == aTravelName

        where:
        aTravelName | _
        "A travel" | _
    }
}
