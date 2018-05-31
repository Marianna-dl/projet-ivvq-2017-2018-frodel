package com.frodel.controller;

import com.frodel.model.City;
import com.frodel.model.Country;
import com.frodel.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller of a country
 */
@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    /**
     * @api {get} /country/{name}
     * @apiName findCountryByName
     * @apiGroup Country
     * @apiDescription find a country by its name
     * @apiParam {String} name The name of country to find
     * @apiSuccess {Country} country the country found
     */
    @RequestMapping("/country/{name}")
    public Country findCountryByName(@PathVariable String name) {
        return countryService.findCountryByName(name);
    }

    /**
     * @api {get} /cities/{name}
     * @apiName findCitiesOfCountry
     * @apiGroup Country
     * @apiDescription find cities of country
     * @apiParam {String} name The name of country
     * @apiSuccess {List<City>} cities Cities found for the country
     */
    @RequestMapping("/cities/{name}")
    public List<City> findCitiesOfCountry(@PathVariable String name) {
        return countryService.findCitiesOfCountry(name);
    }

    public Iterable<Country> findAllCountries() {
        return countryService.findAllCountries();
    }

}
