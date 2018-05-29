package com.frodel.repositories;

import com.frodel.model.Place;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PlaceRepository extends PagingAndSortingRepository<Place, Long> {
}
