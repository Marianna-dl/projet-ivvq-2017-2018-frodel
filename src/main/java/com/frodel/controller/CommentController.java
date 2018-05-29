package com.frodel.controller;

import com.frodel.model.Comment;
import com.frodel.model.Travel;
import com.frodel.model.User;
import com.frodel.services.CommentService;
import com.frodel.services.TravelService;
import com.frodel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller of a travel
 */
@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    /**
     * @api {post} /comment/
     * @apiName addComment
     * @apiGroup Comment
     * @apiDescription Add a Comment
     *
     * @apiParam {String} content The content of comment
     * @apiParam {String} idCommentator The id of the user who created the Comment
     *
     * @apiSuccess {Comment} comment The new Comment
     */
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public Comment addComment(@RequestParam(value = "content") String content, @RequestParam(value = "idCommentator") String idCommentator) {

        User commentator = userService.findOneUser(Long.parseLong(idCommentator));
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setCommentator(commentator);
        commentService.saveComment(comment);
        return comment;
    }

}
