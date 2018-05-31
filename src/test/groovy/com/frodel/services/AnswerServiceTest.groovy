package groovy.com.frodel.services

import com.frodel.model.Answer
import com.frodel.repositories.AnswerRepository
import com.frodel.services.AnswerService
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.repository.PagingAndSortingRepository
import spock.lang.Specification

/**
 * Created by Franck on 30/05/2018.
 */
@SpringBootTest
class AnswerServiceTest extends Specification{
    AnswerService answerService
    AnswerRepository answerRepository

    void setup() {
        answerRepository = Mock()
        answerService = new AnswerService()
        answerService.answerRepository = answerRepository
    }

    def "check the type of a question"() {
        expect: "utilisateurRepository is a Spring repository"
        answerRepository instanceof PagingAndSortingRepository
    }

    def "test delegation of save of a Question to the repository"() {
        given: "a question"
        def answer = Mock(Answer)

        when: "the question is saved"
        answerService.saveAnswer(answer);

        then: "the save is delegated to the commentRepository"
        1 * answerRepository.save(answer)
    }
}
