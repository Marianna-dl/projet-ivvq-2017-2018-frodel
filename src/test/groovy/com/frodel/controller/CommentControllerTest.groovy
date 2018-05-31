package com.frodel.controller

import com.frodel.services.CommentService
import com.frodel.services.UserService
import spock.lang.Specification
import spock.lang.Unroll

class CommentControllerTest extends Specification {

    private CommentService commentService
    private CommentController commentController
    private UserService userService;

    void setup() {
        commentService = Mock();
        userService = Mock();
        commentController = new CommentController(commentService: commentService, userService: userService)
    }

    @Unroll
    void "add a comment by calling controller"() {
        when: "adding a comment"
        commentController.addComment("it's a comment", "1")

        then: "the request id performed"
        1 * commentService.saveComment(_)
    }

    def "test to find a comment with a given id by calling controller"() {

        when: "requesting for a comment with the given id"
        commentController.findCommentById(1)

        then: "the request is performed"
        1 * commentService.findCommentById(1)
    }

}
