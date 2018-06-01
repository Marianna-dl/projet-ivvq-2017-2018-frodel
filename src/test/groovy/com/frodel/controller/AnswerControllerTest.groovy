package groovy.com.frodel.controller

import com.frodel.controller.AnswerController
import com.frodel.services.AnswerService
import spock.lang.Specification

/**
 * Created by Franck on 31/05/2018.
 */
class AnswerControllerTest extends Specification{
    private AnswerService answerService
    private AnswerController answerController

    void setup() {
        answerService = Mock();
        answerController = new AnswerController(answerService: answerService)
    }

    def "test to find all the answers by calling controller"() {

        when: "requesting for all the answers"
        answerController.findAllAnswers()

        then: "the request is performed"
        1 * answerService.findAllAnswers()
    }

    def "test to find all the answers for an answerer by calling controller"() {

        when: "requesting for all the answers for an answerer"
        answerController.findAllAnswersByAnswerer("titi")

        then: "the request is performed"
        1 * answerService.findAnswersByAnswerer("titi")
    }

    def "test to find all the answers for a question by calling controller"() {

        when: "requesting for all the answers for a question"
        answerController.findAllAnswersByQuestionId(1)

        then: "the request is performed"
        1 * answerService.findAnswersByQuestionId(1)
    }
}
