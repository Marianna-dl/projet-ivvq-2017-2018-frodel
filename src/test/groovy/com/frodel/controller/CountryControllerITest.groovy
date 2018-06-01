package com.frodel.controller

import com.frodel.model.City
import com.frodel.model.Country
import com.frodel.services.InitialisationService
import jdk.nashorn.internal.runtime.arrays.IteratorAction
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpHeaders
import org.springframework.test.context.ContextConfiguration
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import org.springframework.web.client.RestTemplate
import spock.lang.Specification
import spock.lang.Unroll

@ContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CountryControllerITest extends Specification {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private InitialisationService initialisationService;

    void "get a country by calling url"() {
        when: "get a country requested"
        Country country = this.restTemplate.getForObject("/country/France", Country.class)

        then: "the recover country is the same that the country of initialisationService"
        country.id == initialisationService.france.id

        and:
        country.name == initialisationService.france.name

        and:
        country.cities.size() == initialisationService.france.cities.size()
    }

    void "get a cities of a country by calling url"() {
        when: "get cities requested"
        List<City> cities = this.restTemplate.getForObject("/cities/France", List.class)

        then: "recover cities are the same that cities of initialisationService"
        cities[0].id == initialisationService.toulouse.id

        and:
        cities[0].name == initialisationService.toulouse.name

        and:
        cities[1].id == initialisationService.paris.id

        and:
        cities[1].name == initialisationService.paris.name
    }

    def "test to find all countries by calling url"() {
        when: "find all countries requested"
        Iterable<Country> countries = this.restTemplate.getForObject("/countries", Iterable.class);

        then:"the result provides 4 countries"
        countries.size() >= 4
    }
}
