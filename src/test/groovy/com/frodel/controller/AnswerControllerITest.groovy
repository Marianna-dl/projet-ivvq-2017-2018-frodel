package groovy.com.frodel.controller

import com.frodel.TravexApplication
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
        String body = this.restTemplate.getForObject("/answers", String.class);

        then:"the result provides 2 answers"
        body.contains(String.valueOf(initialisationService.titiMoneyAnswer.id)) && body.contains(String.valueOf(initialisationService.totoWeatherAnswer.id))
    }

    void "test to find all answers with a given pseudo calling url"() {

        given: "a user pseudo"
        String pseudo = "titi"

        when: "find answers by pseudo requested"
        String body = this.restTemplate.getForObject("/answers/pseudo/" + pseudo, String.class);

        then:"the result provides 1 answer"
        body.contains(initialisationService.titiMoneyAnswer.content)
    }
    void "test to find all answers with a given question id calling url"() {

        given: "a question id"
        Long questionId = 1

        when: "find answers by question id requested"
        String body = this.restTemplate.getForObject("/answers/questionId/" + questionId, String.class);

        then:"the result provides 1 answer"
        body.contains(initialisationService.totoWeatherAnswer.content)
    }

}
