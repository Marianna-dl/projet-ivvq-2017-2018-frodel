package com.frodel.services;

import com.frodel.model.Question;
import com.frodel.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Franck on 28/05/2018.
 */
@Service
public class QuestionService {

    @Autowired

    private QuestionRepository questionRepository ;

    /**
     * Save the given question
     * @param question the question
     * @return the saved question
     */

    public Question saveQuestion(Question question) {

        return questionRepository.save(question) ;

    }

    /**
     * Find all the questions for an interrogator
     *
     * @param pseudoInterrogator The id of the interrogator that asked the questions
     * @return The Iterable<Question> found or null if the interrogator wasn't found
     */
    public Iterable<Question> findQuestionsByInterrogator(String pseudoInterrogator) {
        return (Iterable<Question>) questionRepository.findQuestionsByInterrogator(pseudoInterrogator);
    }
}
