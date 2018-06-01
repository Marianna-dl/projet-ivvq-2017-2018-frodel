package com.frodel.controller;

import com.frodel.model.Answer;
import com.frodel.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller of an Answer
 */
@RestController
@CrossOrigin
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    /**
     * @api {get} /answers
     * @apiName findAllAnswers
     * @apiGroup Answer
     * @apiDescription find all the answers
     *
     *
     * @apiSuccess {Iterable<Answer>} the list of answer
     */
    @RequestMapping("/answers")
    public Iterable<Answer> findAllAnswers()
    {
        return answerService.findAllAnswers();
    }


    /**
     * @api {get} /answers/pseudo/{pseudo}
     * @apiName findAllAnswersByAnswerer
     * @apiGroup Answer
     * @apiDescription find all the answers for an answerer
     *
     *
     * @apiSuccess {Iterable<Answer>} the list of answers
     */
    @RequestMapping("/answers/pseudo/{pseudoAnswerer}")
    public Iterable<Answer> findAllAnswersByAnswerer(@PathVariable String pseudoAnswerer)
    {
        return answerService.findAnswersByAnswerer(pseudoAnswerer);
    }

    /**
     * @api {get} /answers/questionId/{questionId}
     * @apiName findAllAnswersByQuestionId
     * @apiGroup Answer
     * @apiDescription find all the answers for a questionId
     *
     *
     * @apiSuccess {Iterable<Answer>} the list of answers
     */
    @RequestMapping("/answers/questionId/{questionId}")
    public Iterable<Answer> findAllAnswersByQuestionId(@PathVariable long questionId)
    {
        return answerService.findAnswersByQuestionId(questionId);
    }
}
