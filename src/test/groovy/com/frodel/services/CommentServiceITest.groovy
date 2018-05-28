package com.frodel.services

import com.frodel.TravexApplication
import com.frodel.model.Article
import com.frodel.model.Comment
import com.frodel.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import javax.validation.ConstraintViolationException

/**
 * Created by hichem on 13/04/2018.
 */
@ContextConfiguration
@SpringBootTest(classes = TravexApplication.class,webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
class CommentServiceITest extends Specification{
    @Autowired CommentService commentService
    def "test save a valid comment"() {
        given: "valid comment"
        Comment comment = new Comment(title:"title",mark:1,content: "my comment",commentator: new User(pseudo :"Dupont",mdp:"azertyuiop",email:"jd@jd.com",comments:null),article: new Article())

        when: "the comment is Saved"
        commentService.saveComment(comment);

        then: "the comment has an id"
        comment.id != null

    }

    def "test sauvegard invalid comment"() {
        given: "invalid comment"
        Comment comment = new Comment(title:  "title",mark:  2,content : null,commentator: null,article: null)

        when: "the comment is saved"
        commentService.saveComment(comment);

        then: "thrown Exception"
        thrown ConstraintViolationException

        and: "comment has still null id"
        comment.id == null
    }

}
