package groovy.com.frodel.model

import com.frodel.model.Question
import com.frodel.model.User
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
    void "tests the validity of a valid question"(String title, String content, User interrogator) {

        given: "A user asks a question"
        Question question = new Question(title: title, content: content, interrogator: interrogator)

        expect: "The question is valid"
        validator.validate(question).empty

        where:
        title   | content | interrogator
        "Question's title" | "How was the weather ?" | new User()
        null | "What place would you like to go next ?" | new User()
    }

    @Unroll
    void "tests the validity of a non valid question"(String title, String content, User interrogator) {

        given: "A user asks a question"
        Question question = new Question(title: title, content: content, interrogator: interrogator)

        expect: "The question is not valid"
        !validator.validate(question).empty

        where:
        title   | content | interrogator
        "Question's title" | "How was the weather" | new User()
        "Question's title" | null | new User()
        null             | null | new User()
        "How was the weather ?" | null | new User()
        "Question's title" | "How was the weather ?" | null
    }

}
