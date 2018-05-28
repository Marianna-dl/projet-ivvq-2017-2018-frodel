package groovy.com.frodel.services

import com.frodel.TravexApplication
import com.frodel.model.Question
import com.frodel.services.QuestionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification
import javax.validation.ConstraintViolationException


/**
 * Created by Franck on 28/05/2018.
 */
@ContextConfiguration
@SpringBootTest(classes = TravexApplication.class,webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
class QuestionServiceITest extends Specification {
    @Autowired QuestionService questionService

        def "test save a valid question"() {
               given: "valid question"
                Question question = new Question("My question","How was the weather ?")

                        when: "the question is Saved"
                        questionService.saveQuestion(question);

                        then: "the question has an id"
                        question.id != null

                    }

        def "test save an non valid question"() {
                given: "invalid question"
                Question question = new Question("My question",null)

                        when: "the question is saved"
                        questionService.saveQuestion(question);

                        then: "thrown Exception"
                thrown ConstraintViolationException

                        and: "question has still null id"
                        question.id == null
            }
}
