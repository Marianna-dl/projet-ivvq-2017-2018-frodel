package com.frodel.repositories;

import com.frodel.model.Answer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Franck on 30/05/2018.
 */
public interface AnswerRepository  extends PagingAndSortingRepository<Answer, Long> {
    @Query("select answer from Answer answer where answer.answerer.pseudo = ?1")
    Iterable<Answer> findAnswersByAnswerer(String pseudoAnswerer);

    @Query("select answer from Answer answer where answer.question.id = ?1")
    Iterable<Answer> findAnswersByQuestionId(Long questionId);
}
