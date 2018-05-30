package com.frodel.repositories;

import com.frodel.model.Travel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Marianna on 13/04/2018.
 */
public interface TravelRepository extends PagingAndSortingRepository<Travel, Long> {

    @Query("select travel from Travel travel where travel.name = ?1")
    Iterable<Travel>  findTravelByName(String name);

}
