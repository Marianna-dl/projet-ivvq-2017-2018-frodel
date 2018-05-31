package groovy.com.frodel.services

import com.frodel.TravexApplication
import com.frodel.model.Answer
import com.frodel.model.Question
import com.frodel.model.User
import com.frodel.services.AnswerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import javax.validation.ConstraintViolationException

/**
 * Created by Franck on 30/05/2018.
 */
@ContextConfiguration
@SpringBootTest(classes = TravexApplication.class,webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
class AnswerServiceITest extends Specification {
    @Autowired AnswerService answerService

    def "test save a valid answer"() {
        given: "a valid user that answers the question"
        User answerer = new User(pseudo :"Dupont",mdp:"dupontMdp",email:"Dupont@frodel.com", questions: null, answers: null)


        and: "a valid user that asks the question"
        User interrogator = new User(pseudo :"Dupond",mdp:"dupondMdp",email:"Dupond@frodel.com", questions: null, answers: null)

        and: "a valid question"
        Question question = new Question(title: "My question",content: "How was the weather ?", interrogator: interrogator, answers: null)

        and: "a valid answer"
        Answer answer = new Answer(content: "The weather was SPLENDID!", answerer: answerer, question: question)

        when: "the answer is Saved"
        answerService.saveAnswer(answer);

        then: "the answer has an id"
        answer.id != null

    }

    def "test save an non valid answer"() {
        given: "invalid answer"
        Answer answer = new Answer(content: null, answerer: null, question: null)

        when: "the answer is saved"
        answerService.saveAnswer(answer);

        then: "thrown Exception"
        thrown ConstraintViolationException

        and: "answer has still null id"
        answer.id == null
    }
}
