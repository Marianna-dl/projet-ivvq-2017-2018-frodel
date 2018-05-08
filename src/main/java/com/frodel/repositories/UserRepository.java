package com.frodel.repositories;

import com.frodel.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by hichem on 30/03/2018.
 */
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
}
