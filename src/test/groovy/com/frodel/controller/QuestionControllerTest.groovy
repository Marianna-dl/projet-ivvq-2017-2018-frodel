package groovy.com.frodel.controller

import com.frodel.controller.QuestionController
import com.frodel.services.QuestionService
import com.frodel.services.UserService
import spock.lang.Specification

/**
 * Created by Franck on 31/05/2018.
 */
class QuestionControllerTest extends Specification {

    private QuestionService questionService
    private QuestionController questionController
    private UserService userService;

    void setup() {
        questionService = Mock();
        userService = Mock();
        questionController = new QuestionController(questionService: questionService, userService: userService)
    }

    def "test to find all the questions for an=n interrogator by calling controller"() {

        when: "requesting for all the questions for an interrogator"
        questionController.getQuestionsByInterrogator("titi")

        then: "the request is performed"
        1 * questionService.findQuestionsByInterrogator("titi")
    }
}
