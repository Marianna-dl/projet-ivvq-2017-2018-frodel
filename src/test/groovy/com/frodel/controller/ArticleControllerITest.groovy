package com.frodel.controller

import com.frodel.model.Article
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
        Iterable<Article> articles = this.restTemplate.getForObject("/articles", Iterable.class);

        then:"the result provides 2 articles"
        articles.size() >= 2
    }


}
