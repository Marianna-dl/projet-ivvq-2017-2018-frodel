package com.frodel.controller;

import com.frodel.model.Question;
import com.frodel.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controller of a Question
 */
@RestController
@CrossOrigin
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    /**
     * @api {get} /questions
     * @apiSampleRequest /questions
     * @apiName findAllQuestions
     * @apiGroup Question
     * @apiDescription find all the questions
     *
     *
     * @apiSuccess {Question[]} Questions the list of questions
     */
    @RequestMapping("/questions")
    public Iterable<Question> findAllQuestions()
    {
        return questionService.findAllQuestions();
    }


    /**
     * @api {get} /questions/pseudo/{pseudo}
     * @apiSampleRequest /questions/pseudo/titi
     * @apiParamExample {json} Request-Example:
     *     {
     *       "pseudo" : [{"titi"}, {"toto"}]
     *     }
     * @apiName findAllQuestionsByInterrogator
     * @apiGroup Question
     * @apiDescription find all the questions for an interrogator
     * @apiParam {String} pseudoInterrogator The name of the interrogator
     *
     * @apiSuccess {Question[]} Questions the list of questions
     */
    @RequestMapping("/questions/pseudo/{pseudoInterrogator}")
    public Iterable<Question> findAllQuestionsByInterrogator(@PathVariable String pseudoInterrogator)
    {
        return questionService.findQuestionsByInterrogator(pseudoInterrogator);
    }
}
