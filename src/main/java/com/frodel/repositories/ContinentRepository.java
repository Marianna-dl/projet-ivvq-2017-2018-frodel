package com.frodel.repositories;

import com.frodel.model.Continent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ContinentRepository extends PagingAndSortingRepository<Continent, Long> {

    @Query("select continent from Continent continent where continent.name = ?1")
    Continent findContinentByName(String name);

}
