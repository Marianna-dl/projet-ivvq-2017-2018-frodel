package com.frodel.controller

import com.frodel.model.Continent
import com.frodel.services.ContinentService
import com.frodel.services.InitialisationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification
import spock.lang.Unroll

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

}
