package com.frodel.controller

import com.frodel.model.Continent
import com.frodel.model.Country
import com.frodel.services.InitialisationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ContinentControllerITest extends Specification {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private InitialisationService initialisationService;

    void "get a continent by calling url"() {
        when: "get a continent requested"
        Continent continent = this.restTemplate.getForObject("/continent/Europe", Continent.class)

        then: "the recover continent is the same that the continent of initialisationService"
        continent.id == initialisationService.europe.id

        and:
        continent.name == initialisationService.europe.name

        and:
        continent.countries.size() == initialisationService.europe.countries.size()
    }

    void "get a countries of a continent by calling url"() {
        when: "get countries requested"
        List<Country> countries = this.restTemplate.getForObject("/countries/Europe", List.class)

        then: "recover countries are the same that countries of initialisationService"
        countries[0].id == initialisationService.ireland.id
        and:
        countries[0].name == initialisationService.ireland.name
        and:
        countries[0].cities.size() == initialisationService.ireland.cities.size()

        and:
        countries[1].id == initialisationService.france.id
        and:
        countries[1].name == initialisationService.france.name
        and:
        countries[1].cities.size() == initialisationService.france.cities.size()

        and:
        countries[2].id == initialisationService.espagne.id
        and:
        countries[2].name == initialisationService.espagne.name
        and:
        countries[2].cities.size() == initialisationService.espagne.cities.size()
    }

}
