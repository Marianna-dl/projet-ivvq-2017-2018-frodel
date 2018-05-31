package com.frodel.services;

import com.frodel.model.Country;
import com.frodel.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    /**
     * Save the given country
     *
     * @param country the country
     * @return the saved country
     */
    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }

    /**
     * Find a country by its names
     *
     * @param name The name of country to find
     * @return The country found or null if the country wasn't found
     */
    public Country findCountryByName(String name) {
        return countryRepository.findCountryByName(name);
    }
}