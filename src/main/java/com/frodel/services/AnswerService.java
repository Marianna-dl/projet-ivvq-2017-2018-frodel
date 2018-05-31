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
}
