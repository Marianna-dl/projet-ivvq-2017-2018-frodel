package groovy.com.frodel.controller

import com.frodel.model.Question
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.ContextConfiguration
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import spock.lang.Specification

@ContextConfiguration
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
class QuestionControllerITest extends Specification {
    @Autowired
    private TestRestTemplate restTemplate;

    void "add a question by calling url"(String aQuestionContent) {

        when: "add question requested"
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("content", aQuestionContent);
        map.add("idInterrogator", "1");
        Question question = restTemplate.postForObject("/question", map, question.class)

        then: "the recover content of the question is the same that the send content"
        question.content == aQuestionContent

        where:
        aQuestionContent | _
        "A question" | _
    }
}
