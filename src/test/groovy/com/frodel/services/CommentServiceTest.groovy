package com.frodel.services

import com.frodel.model.Comment
import com.frodel.model.User
import com.frodel.repositories.CommentRepository
import com.frodel.repositories.UserRepository
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.repository.PagingAndSortingRepository
import spock.lang.Specification


/**
 * Created by hichem on 30/03/2018.
 */
@SpringBootTest
class CommentServiceTest extends Specification {

    CommentService commentService
    CommentRepository commentRepository

    void setup() {
        commentRepository = Mock()
        commentService = new CommentService()
        commentService.commentRepository = commentRepository
    }

    def "check type of commentRepository"() {
        expect: "commentRepository is a Spring repository"
        commentRepository instanceof PagingAndSortingRepository
    }

    def "test delegation of save of an Comment to the repository"() {
        given: "a Comment"
        def comment = Mock(Comment)

        when: "the comment is saved"
        commentService.saveComment(comment);

        then: "the save is delegated to the commentRepository"
        1 * commentRepository.save(comment)
    }


}
