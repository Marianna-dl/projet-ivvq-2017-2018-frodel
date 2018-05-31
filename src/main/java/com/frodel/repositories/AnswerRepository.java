package com.frodel.repositories;

import com.frodel.model.Answer;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Franck on 30/05/2018.
 */
public interface AnswerRepository  extends PagingAndSortingRepository<Answer, Long> {
}
