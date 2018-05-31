package com.frodel.controller;

import com.frodel.model.Question;
import com.frodel.model.User;
import com.frodel.services.QuestionService;
import com.frodel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller of a Question
 */
@RestController
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @Autowired
    private UserService userService;

    /**
     * @api {post} /question/
     * @apiName addQuestion
     * @apiGroup Question
     * @apiDescription Add a Question
     *
     * @apiParam {String} content The content of the question
     * @apiParam {String} idInterrogator The id of the user who asked the Question
     *
     * @apiSuccess {Question} question The new Question
     */
    @RequestMapping(value = "/question", method = RequestMethod.POST)
    public Question addQuestion(@RequestParam(value = "content") String content, @RequestParam(value = "idInterrogator") String idInterrogator) {

        User interrogator = userService.findOneUser(Long.parseLong(idInterrogator));
        Question question = new Question();
        question.setContent(content);
        question.setInterrogator(interrogator);
        questionService.saveQuestion(question);
        return question;
    }
}
