package groovy.com.frodel.model

import com.frodel.model.Question
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification
import spock.lang.Unroll

import javax.validation.Validation
import javax.validation.Validator
import javax.validation.ValidatorFactory

/**
 * Created by Franck on 18/05/2018.
 */
@SpringBootTest
class QuestionTest extends Specification {
    Validator validator

    void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Unroll
    void "tests the validity of a valid question"(String title, String content) {

        given: "A user asks a question"
        Question question = new Question(title, content)

        expect: "The question is valid"
        validator.validate(question).empty

        where:
        title   | content
        "Question's title" | "How was the weather ?"
        null | "What place would you like to go next ?"
    }

    @Unroll
    void "tests the validity of a non valid question"(String title, String content) {

        given: "A user asks a question"
        Question question = new Question(title, content)

        expect: "The question is not valid"
        !validator.validate(question).empty

        where:
        title   | content
        "Question's title" | "How was the weather"
        "Question's title" | null
        null             | null
        "How was the weather ?" | null
    }

}
