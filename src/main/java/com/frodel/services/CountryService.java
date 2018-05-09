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

}
