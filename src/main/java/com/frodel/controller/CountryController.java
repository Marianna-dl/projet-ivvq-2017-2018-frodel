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

    @RequestMapping("/country/{name}")
    public Country getCountry(@PathVariable String name)
    {
        return countryService.findCountryByName(name);
    }

}
