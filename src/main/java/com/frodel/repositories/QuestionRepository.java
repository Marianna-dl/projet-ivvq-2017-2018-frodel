package com.frodel.repositories;

import com.frodel.model.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Franck on 28/05/2018.
 */
public interface QuestionRepository extends PagingAndSortingRepository<Question, Long> {

    @Query("select question from Question question where question.interrogator.pseudo = ?1")
    Iterable<Question> findQuestionsByInterrogator(String pseudoInterrogator);
}
