package com.frodel.controller;

import com.frodel.model.City;
import com.frodel.model.Country;
import com.frodel.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller of a country
 */
@RestController
@CrossOrigin
public class CountryController {

    @Autowired
    private CountryService countryService;

    /**
     * @api {get} /country/{name}
     * @apiSampleRequest /country/Japon
     * @apiParamExample {json} Request-Example:
     *     {
     *       "name" : [{"Japon"}, {"Irelande"}, {"France"}]
     *     }
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
     * @apiSampleRequest /cities/Japon
     * @apiParamExample {json} Request-Example:
     *     {
     *       "name" : [{"Japon"}, {"Irelande"}, {"France"}]
     *     }
     * @apiName findCitiesOfCountry
     * @apiGroup Country
     * @apiDescription find cities of country
     * @apiParam {String} name The name of country
     *
     * @apiSuccess {City[]} cities Cities found for the country
     */
    @RequestMapping("/cities/{name}")
    public List<City> findCitiesOfCountry(@PathVariable String name) {
        return countryService.findCitiesOfCountry(name);
    }

    /**
     * @api {get} /countries/
     * @apiSampleRequest /countries/
     * @apiName findAllCountries
     * @apiGroup Country
     * @apiDescription Find all countries
     * @apiSuccess {Country[]} Countries All countries
     */
    @RequestMapping("/countries")
    public Iterable<Country> findAllCountries() {
        return countryService.findAllCountries();
    }

}
