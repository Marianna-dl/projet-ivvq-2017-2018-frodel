package groovy.com.frodel.controller

import com.frodel.controller.QuestionController
import com.frodel.services.QuestionService
import spock.lang.Specification

/**
 * Created by Franck on 31/05/2018.
 */
class QuestionControllerTest extends Specification {

    private QuestionService questionService
    private QuestionController questionController

    void setup() {
        questionService = Mock();
        questionController = new QuestionController(questionService: questionService)
    }

    def "test to find all the questions by calling controller"() {

        when: "requesting for all the questions for an interrogator"
        questionController.findAllQuestions()

        then: "the request is performed"
        1 * questionService.findAllQuestions()
    }

    def "test to find all the questions for an interrogator by calling controller"() {

        when: "requesting for all the questions for an interrogator"
        questionController.findAllQuestionsByInterrogator("titi")

        then: "the request is performed"
        1 * questionService.findQuestionsByInterrogator("titi")
    }
}
