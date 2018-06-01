package groovy.com.frodel.controller

import com.frodel.TravexApplication
import com.frodel.model.Question
import com.frodel.services.InitialisationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration
@SpringBootTest(classes = TravexApplication.class,webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
class QuestionControllerITest extends Specification {
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private InitialisationService initialisationService;

    void "test to find all the questions by calling the url"() {

        when: "find questions by pseudo requested"
        Iterable<Question> questions = this.restTemplate.getForObject("/questions", Iterable.class);

        then:"the result provides 2 question"
        questions.size() >= 2

        and: "the two firsts elements are the same that the ones in initialisation service"
        questions[0].id == initialisationService.titiWeatherQuestion.id
        questions[1].id == initialisationService.totoMoneyQuestion.id
    }

    void "test to find all questions with a given pseudo calling url"() {

        given: "a user pseudo"
        String pseudo = "titi"

        when: "find questions by pseudo requested"
        Iterable<Question> questions = this.restTemplate.getForObject("/questions/pseudo/" + pseudo, Iterable.class);

        then:"the result provides 1 question"
        questions.size() >= 1

        and: "the first element has the same content that the one in initialisation service"
        questions[0].content == initialisationService.titiWeatherQuestion.content
    }

}
