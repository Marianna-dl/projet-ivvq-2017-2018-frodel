package groovy.com.frodel.controller

import com.frodel.controller.QuestionController
import com.frodel.services.QuestionService
import com.frodel.services.UserService
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by Franck on 31/05/2018.
 */
@SpringBootTest
class QuestionControllerTest extends Specification {

    private QuestionService questionService
    private QuestionController questionController
    private UserService userService;

    void setup() {
        questionService = Mock();
        userService = Mock();
        questionController = new QuestionController(questionService: questionService, userService: userService)
    }

    @Unroll
    void "add a question by calling controller"() {
        when: "adding a question"
        questionController.addQuestion("Is it a question ?", "1")

        then: "the request id performed"
        1 * questionService.saveQuestion(_)
    }
}
