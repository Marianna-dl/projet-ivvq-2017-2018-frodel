package com.frodel.services;

import com.frodel.model.Comment;
import com.frodel.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hichem on 30/03/2018.
 */
@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository ;

    /**
     * Save the given comment
     * @param comment the comment
     * @return the saved comment
     */
    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment) ;
    }

    public Comment findCommentById(Long id) {
        return commentRepository.findOne(id);
    }
}
