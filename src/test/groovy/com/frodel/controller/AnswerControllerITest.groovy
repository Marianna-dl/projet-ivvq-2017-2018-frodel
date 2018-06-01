package groovy.com.frodel.controller

import com.frodel.TravexApplication
import com.frodel.model.Answer
import com.frodel.services.InitialisationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration
@SpringBootTest(classes = TravexApplication.class,webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
class AnswerControllerITest extends Specification {
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private InitialisationService initialisationService;

    void "test to find all the answers by calling the url"() {

        when: "find all the answers"
        Iterable<Answer> answers = this.restTemplate.getForObject("/answers", Iterable.class);

        then:"the result provides 2 answers"
        answers.size() >= 2
    }

    void "test to find all answers with a given pseudo calling url"() {

        given: "a user pseudo"
        String pseudo = initialisationService.titiUser.pseudo

        when: "find answers by pseudo requested"
        Iterable<Answer> answers = this.restTemplate.getForObject("/answers/pseudo/" + pseudo, Iterable.class);

        then:"the result provides 1 answer"
        answers.size() >= 1
    }
    void "test to find all answers with a given question id calling url"() {

        given: "a question id"
        Long questionId = 1

        when: "find answers by question id requested"
        Iterable<Answer> answers = this.restTemplate.getForObject("/answers/questionId/" + questionId, Iterable.class);

        then:"the result provides 1 answer"
        answers.size() >= 1
    }

}
