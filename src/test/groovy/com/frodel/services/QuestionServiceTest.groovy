package groovy.com.frodel.services

import com.frodel.model.Question
import com.frodel.repositories.QuestionRepository
import com.frodel.services.QuestionService
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.repository.PagingAndSortingRepository
import spock.lang.Specification

/**
 * Created by Franck on 28/05/2018.
 */
@SpringBootTest
class QuestionServiceTest extends Specification{
    QuestionService questionService
    QuestionRepository questionRepository

    void setup() {
        questionRepository = Mock()
        questionService = new QuestionService()
        questionService.questionRepository = questionRepository
    }

    def "check the type of a question"() {
        expect: "utilisateurRepository is a Spring repository"
        questionRepository instanceof PagingAndSortingRepository
    }

    def "test delegation of save of a Question to the repository"() {
        given: "a question"
        def question = Mock(Question)

        when: "the question is saved"
        questionService.saveQuestion(question);

        then: "the save is delegated to the commentRepository"
        1 * questionRepository.save(question)
    }
}
