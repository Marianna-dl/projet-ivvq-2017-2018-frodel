package com.frodel.repositories;

import com.frodel.model.City;
import com.frodel.model.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CityRepository extends PagingAndSortingRepository<City, Long> {

    @Query("select city from City city where city.name = ?1")
    City findCityByName(String name);
}
