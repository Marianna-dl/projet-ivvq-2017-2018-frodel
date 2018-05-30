package groovy.com.frodel.model

import com.frodel.model.Answer
import com.frodel.model.Question
import com.frodel.model.User
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification
import spock.lang.Unroll

import javax.validation.Validation
import javax.validation.Validator
import javax.validation.ValidatorFactory

/**
 * Created by Franck on 30/05/2018.
 */
@SpringBootTest
class AnswerTest extends Specification {
    Validator validator

    void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Unroll
    void "tests the validity of a valid question"(String content, User answerer, Question question) {

        given: "A user answers to a question"
        Answer answer = new Answer(content: content, answerer: answerer, question: question)

        expect: "The answer is valid"
        validator.validate(answer).empty

        where:
        content | answerer | question
        "The weather was SPLENDID!" | new User() | new Question()
    }

    @Unroll
    void "tests the validity of a non valid question"(String content, User answerer, Question question) {

        given: "A user answers a question"
        Answer answer = new Answer(content: content, answerer: answerer, question: question)

        expect: "The answer is not valid"
        !validator.validate(answer).empty

        where:
        content | answerer | question
        null | new User() | new Question()
        "The weather was SPLENDID!" | null | new Question()
        "The weather was SPLENDID!" | new User() | null
    }

}
