package com.frodel.controller;

import com.frodel.model.Article;
import com.frodel.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * @api {get} /articles/
     * @apiSampleRequest /articles/
     * @apiName findAllArticles
     * @apiGroup Article
     * @apiDescription find all articles
     *
     *
     * @apiSuccess {Article[]} articles the list of articles
     */
    @RequestMapping("/articles")
    public Iterable<Article> findAllArticles() {
        return articleService.findAllArticles();
    }


}
