package com.frodel.repositories;

import com.frodel.model.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface CountryRepository extends PagingAndSortingRepository<Country, Long> {

    @Query("select country from Country country where country.name = ?1")
    Country findCountryByName(String name);
}
