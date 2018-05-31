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
class QuestionControllerITest extends Specification {
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private InitialisationService initialisationService;

    void "test to find all questions with a given pseudo calling url"() {

        given: "a user pseudo"
        String pseudo = "titi"

        when: "find questions by pseudo requested"
        String body = this.restTemplate.getForObject("/questions/pseudo/" + pseudo, String.class);

        then:"the result provides 1 question"
        body.contains(initialisationService.titiWeatherQuestion.content)
    }

}
