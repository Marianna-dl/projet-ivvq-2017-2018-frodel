package com.frodel.repositories;

import com.frodel.model.Question;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Franck on 28/05/2018.
 */
public interface QuestionRepository extends PagingAndSortingRepository<Question, Long> {
}
