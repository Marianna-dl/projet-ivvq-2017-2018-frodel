package com.frodel.controller

import com.frodel.services.ArticleService
import com.frodel.services.InitialisationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
class ArticleControllerITest extends Specification {

    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private InitialisationService initialisationService;

    def "test to find all articles by calling url"() {

        when: "find articles requested"
        String body = this.restTemplate.getForObject("/articles", String.class);

        then:"the result provides 2 articles"
        body.contains(initialisationService.articleJapan.name)
        body.contains(initialisationService.articleIrelande.name)
    }


}
