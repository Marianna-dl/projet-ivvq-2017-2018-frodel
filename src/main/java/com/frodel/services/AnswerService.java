package com.frodel.services;

import com.frodel.model.Answer;
import com.frodel.repositories.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Franck on 30/05/2018.
 */
@Service
public class AnswerService {

    @Autowired

    private AnswerRepository answerRepository ;

    /**
     * Save the given answer
     * @param answer the answer
     * @return the saved answer
     */

    public Answer saveAnswer(Answer answer) {

        return answerRepository.save(answer) ;

    }

    /**
     * Find all the answers
     *
     * @return The Iterable<Answer> found
     */
    public Iterable<Answer> findAllAnswers() {
        return (Iterable<Answer>) answerRepository.findAll();
    }

    /**
     * Find all the answers for an interrogator
     *
     * @param pseudoAnswerer The id of the answerer that answered the questions
     * @return The Iterable<Answer> found or null if the answerer wasn't found
     */
    public Iterable<Answer> findAnswersByAnswerer(String pseudoAnswerer) {
        return (Iterable<Answer>) answerRepository.findAnswersByAnswerer(pseudoAnswerer);
    }

    /**
     * Find all the answers for a questionId
     *
     * @param questionId The id of the question answered
     * @return The Iterable<Answer> found or null if no answer found
     */
    public Iterable<Answer> findAnswersByQuestionId(Long questionId) {
        return (Iterable<Answer>) answerRepository.findAnswersByQuestionId(questionId);
    }
}
