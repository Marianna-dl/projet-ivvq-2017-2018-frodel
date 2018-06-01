package com.frodel.controller;

import com.frodel.model.Comment;
import com.frodel.model.User;
import com.frodel.services.CommentService;
import com.frodel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controller of a travel
 */
@RestController
@CrossOrigin
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


    /**
     * @api {get} /comment/id/{idComment}
     * @apiSampleRequest /comment/id/1
     * @apiParamExample {json} Request-Example:
     *     {
     *       "idComment" : [{"1"}, {"2"}]
     *     }
     * @apiName findCommentById
     * @apiGroup Comment
     * @apiDescription find a comment with a given id
     *
     * @apiParam {Long} idComment The id of searched comment
     * @apiSuccess {Comment} Comment the comment
     */
    @RequestMapping("/comment/id/{idComment}")
    public Comment findCommentById(@PathVariable Long idComment) {
        return commentService.findCommentById(idComment);
    }

    /**
     * @api {get} /comments/
     * @apiSampleRequest /comments/
     * @apiName findAllComments
     * @apiGroup Comment
     * @apiDescription find all comments
     *
     *
     * @apiSuccess {Comment[]} Comments the list of comments
     */
    @RequestMapping("/comments")
    public Iterable<Comment> findAllComments() {
        return commentService.findAllComments();
    }

}
