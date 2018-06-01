package com.frodel.controller;

import com.frodel.model.Question;
import com.frodel.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controller of a Question
 */
@RestController
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    /**
     * @api {get} /questions
     * @apiName findAllQuestions
     * @apiGroup Question
     * @apiDescription find all the questions
     *
     *
     * @apiSuccess {Iterable<Question>} the list of questions
     */
    @RequestMapping("/questions")
    public Iterable<Question> findAllQuestions()
    {
        return questionService.findAllQuestions();
    }


    /**
     * @api {get} /questions/pseudo/{pseudo}
     * @apiName findAllQuestionsByInterrogator
     * @apiGroup Question
     * @apiDescription find all the questions for an interrogator
     *
     *
     * @apiSuccess {Iterable<Question>} the list of questions
     */
    @RequestMapping("/questions/pseudo/{pseudoInterrogator}")
    public Iterable<Question> findAllQuestionsByInterrogator(@PathVariable String pseudoInterrogator)
    {
        return questionService.findQuestionsByInterrogator(pseudoInterrogator);
    }
}
