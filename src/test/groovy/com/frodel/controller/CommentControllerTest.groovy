package com.frodel.controller

import com.frodel.services.CommentService
import com.frodel.services.TravelService
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

}
