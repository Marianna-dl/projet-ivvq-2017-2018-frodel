package com.frodel.controller;

import com.frodel.model.Country;
import com.frodel.repositories.CountryRepository;
import com.frodel.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     *
     * @apiParam {String} name The name of country to find
     *
     * @apiSuccess {Country} country the country found
     */
    @RequestMapping("/country/{name}")
    public Country findCountryByName(@PathVariable String name)
    {
        return countryService.findCountryByName(name);
    }

}
