package com.frodel.services

import com.frodel.Bootstrap
import com.frodel.TravexApplication
import com.frodel.model.Article
import com.frodel.model.City
import com.frodel.model.Continent
import com.frodel.model.Country
import com.frodel.model.Place
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import javax.transaction.Transactional

@ContextConfiguration
@SpringBootTest(classes = TravexApplication.class ,webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
class ArticleServiceITest extends Specification {

    @Autowired ArticleService articleService
    @Autowired InitialisationService initialisationService
    @Autowired PlaceService placeService
    @Autowired ContinentService continentService

    def "test save a valid article"() {
        given: "a valid article"
        Place place = new Place();
        place.setContinent(initialisationService.asie);
        place.setCity(initialisationService.tokyo);
        place.setCountry(initialisationService.japan);
        placeService.savePlace(place);

        Article article = new Article();
        article.setName("Mon voyage au japon");
        article.setStartDate(new Date(2018, 5, 1));
        article.setEndDate(new Date(2018, 5, 10));
        article.setContent("Mon fabuleux voyage au Japon où j'ai vu des lieux extraordinaires avec des gens super sympa, j'y retournerai c'est sûr !!! ");
        article.setBudget(1500l);
        article.setPlaces(Arrays.asList(place));

        when: "the article is saved"
        articleService.saveArticle(article);

        then: "the article has an id"
        article.id != null

    }

    def "test getting all articles"() {
        given: "2 articles provided by the initialisation service"
        initialisationService.articleJapan
        initialisationService.articleIrelande

        when: "requesting all articles"
        Iterable<Article> articlesIter = articleService.findAllArticles()
        def articles = articlesIter as List<Article>

        then : "the articles are the same given by the initialisation service"
        articles[0].name == initialisationService.articleJapan.name
        articles[1].name == initialisationService.articleIrelande.name
    }


}
