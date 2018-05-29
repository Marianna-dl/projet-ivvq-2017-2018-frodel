package com.frodel.services

import com.frodel.model.Article
import com.frodel.repositories.ArticleRepository
import org.springframework.data.repository.PagingAndSortingRepository
import spock.lang.Specification

class ArticleServiceTest extends Specification{


    ArticleService articleService
    ArticleRepository articleRepository


    void setup() {
        articleRepository = Mock()
        articleService = new ArticleService()
        articleService.articleRepository = articleRepository
    }

    def "check type of articleRepository"() {
        expect: "articleRepository is a Spring repository"
        articleRepository instanceof PagingAndSortingRepository
    }

    def "test delegation of save of an article to the repository"() {
        given: "a travel"
        def article = Mock(Article)

        when: "the article is saved"
        articleService.saveArticle(article);

        then: "the save is delegated to the articleRepository"
        1 * articleRepository.save(article)
    }

}
