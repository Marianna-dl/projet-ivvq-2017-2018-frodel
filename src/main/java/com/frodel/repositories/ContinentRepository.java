package com.frodel.repositories;

import com.frodel.model.Continent;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ContinentRepository extends PagingAndSortingRepository<Continent, Long> {
}
