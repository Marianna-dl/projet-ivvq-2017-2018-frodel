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
     * @apiSampleRequest /answers
     * @apiName findAllAnswers
     * @apiGroup Answer
     * @apiDescription find all the answers
     *
     *
     * @apiSuccess {Answer[]} Answers the list of answer
     */
    @RequestMapping("/answers")
    public Iterable<Answer> findAllAnswers()
    {
        return answerService.findAllAnswers();
    }


    /**
     * @api {get} /answers/pseudo/{pseudo}
     * @apiSampleRequest /answers/pseudo/titi
     * @apiParamExample {json} Request-Example:
     *     {
     *       "pseudo" : [{"titi"}, {"toto"}]
     *     }
     * @apiName findAllAnswersByAnswerer
     * @apiGroup Answer
     * @apiDescription find all the answers for an answerer
     * @apiParam {String} pseudoAnswerer The pseudo of the answerer
     *
     * @apiSuccess {Answer[]} Answers the list of answers
     */
    @RequestMapping("/answers/pseudo/{pseudoAnswerer}")
    public Iterable<Answer> findAllAnswersByAnswerer(@PathVariable String pseudoAnswerer)
    {
        return answerService.findAnswersByAnswerer(pseudoAnswerer);
    }

    /**
     * @api {get} /answers/questionId/{questionId}
     * @apiSampleRequest /answers/questionId/1
     * @apiParamExample {json} Request-Example:
     *     {
     *       "questionId" : [{"1"}, {"2"}]
     *     }
     * @apiName findAllAnswersByQuestionId
     * @apiGroup Answer
     * @apiDescription find all the answers for a questionId
     * @apiParam {long} questionId The id of the question
     *
     * @apiSuccess {Answer[]} Answers the list of answers
     */
    @RequestMapping("/answers/questionId/{questionId}")
    public Iterable<Answer> findAllAnswersByQuestionId(@PathVariable long questionId)
    {
        return answerService.findAnswersByQuestionId(questionId);
    }
}
