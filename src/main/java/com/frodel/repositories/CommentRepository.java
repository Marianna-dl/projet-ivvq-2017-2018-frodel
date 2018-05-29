package com.frodel.repositories;

import com.frodel.model.Comment;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by hichem on 18/05/2018.
 */
public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {
}
