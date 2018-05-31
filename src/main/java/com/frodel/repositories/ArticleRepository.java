package com.frodel.repositories;

import com.frodel.model.Article;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Marianna on 13/04/2018.
 */
public interface ArticleRepository extends PagingAndSortingRepository<Article, Long> {




}
