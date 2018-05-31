package com.frodel.services

import com.frodel.Bootstrap
import com.frodel.TravexApplication
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
    @Autowired Bootstrap bootstrap
    def "test save a valid comment"() {
        given: "valid user"
        User commentator = new User(pseudo :"Dupont",mdp:"azertyuiop",email:"jd@jd.com",comments:null)

        and: "valid comment"
        Comment comment = new Comment(title:"title",mark:1,content: "my comment",commentator: commentator)

        when: "the comment is Saved"
        commentService.saveComment(comment);

        then: "the comment has an id"
        comment.id != null

    }

    def "test sauvegard invalid comment"() {
        given: "invalid comment"
        Comment comment = new Comment(title:  "title",mark:  2,content : null,commentator: null)

        when: "the comment is saved"
        commentService.saveComment(comment);

        then: "thrown Exception"
        thrown ConstraintViolationException

        and: "comment has still null id"
        comment.id == null
    }

    def "test finding a comment by its id"() {
        given: "The instance of InitialisationService provided by the bootstrap object"
        InitialisationService initialisationService = bootstrap.initialisationService


        and: "1 comment id provided by the initialisation service"
        Comment totoComment = initialisationService.totoComment

        when: "requesting a comment"
        Comment comment = commentService.findCommentById(totoComment.id)

        then : "the Comment are the same id given by the initialisation service"
        comment.id == totoComment.id
    }

    def "test getting all comments"() {
        given: "The instance of InitialisationService provided by the bootstrap object"
        InitialisationService initialisationService = bootstrap.initialisationService

        and: "2 comments provided by the initialisation service"
        initialisationService.totoComment
        initialisationService.titiComment

        when: "requesting all comments"
        Iterable<Comment> commentsIter = commentService.findAllComments()
        def comments = commentsIter as List<Comment>

        then : "the comment are the same given by the initialisation service"
        comments[0].content == initialisationService.totoComment.content
        comments[1].content == initialisationService.titiComment.content
    }

}
