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

     * @param question the utilisateur

     * @return the saved question

     */

    public Question saveQuestion(Question question) {

        return questionRepository.save(question) ;

    }
}
