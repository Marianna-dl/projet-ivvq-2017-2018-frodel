package com.frodel.controller

import com.frodel.model.Article
import com.frodel.services.ArticleService
import spock.lang.Specification

class ArticleControllerTest extends Specification {

    private ArticleService articleService
    private ArticleController articleController

    void setup() {
        articleService = Mock();
        articleController = new ArticleController(articleService: articleService)
    }

    def "test to find all articles by calling controller"() {

        when: "requesting for all articles"
        articleController.findAllArticles()

        then: "the request is performed"
        1 * articleService.findAllArticles()
    }


}
