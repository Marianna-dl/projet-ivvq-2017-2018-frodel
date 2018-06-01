package com.frodel.services;

import com.frodel.model.City;
import com.frodel.model.Country;
import com.frodel.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * Find cities of country by its name
     *
     * @param name The name of the country
     * @return Cities of country
     */
    public List<City> findCitiesOfCountry(String name) {
        List<City> cities = null;
        Country country = countryRepository.findCountryByName(name);
        if (country != null) {
            cities = country.getCities();
        }
        return cities;
    }

    /**
     * Find all countries
     *
     * @return All countries
     */
    public Iterable<Country> findAllCountries() {
        return countryRepository.findAll();
    }
}