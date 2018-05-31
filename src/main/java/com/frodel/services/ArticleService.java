package com.frodel.services;

import com.frodel.model.Article;
import com.frodel.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Marianna on 13/04/2018.
 */
@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private TravelService travelService;

    /**
     * Save the given article
     * @param article the article
     * @return the saved article
     */
    public Article saveArticle(Article article) {
        return articleRepository.save(article) ;
    }

    public Iterable<Article> findAllArticles() {
        return articleRepository.findAll();
    }

}
