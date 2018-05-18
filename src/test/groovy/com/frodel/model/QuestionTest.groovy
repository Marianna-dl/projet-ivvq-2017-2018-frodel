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
    void "test la validite d'une question valide"(String title, String content) {

        given: "un utilisateur pose une question"
        Question question = new Question(title, content)

        expect: "la question est valide"
        validator.validate(question).empty

        where:
        title   | content
        "Titre question" | "Faisait-il beau ?"
        null | "Quel endroit allez vous visiter ensuite ?"
    }

    @Unroll
    void "test la validite d'une question invalide"(String title, String content) {

        given: "un utilisateur pose une question"
        Question question = new Question(title, content)

        expect: "la question est invalide"
        !validator.validate(question).empty

        where:
        title   | content
        "Titre question" | "Faisait-il beau"
        "Titre question" | null
        null             | null
        "Faisait-il beau ?" | null
    }

}
