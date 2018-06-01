package com.frodel.controller;

import com.frodel.model.Continent;
import com.frodel.model.Country;
import com.frodel.services.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by leafo on 29/05/2018.
 */
@RestController
@CrossOrigin
public class ContinentController {

    @Autowired
    private ContinentService continentService;

    /**
     * @api {get} /continent/{name}
     * @apiSampleRequest /continent/Asie
     * @apiParamExample {json} Request-Example:
     *     {
     *       "name" : [{"Asie"}, {"Europe"}]
     *     }
     * @apiName getContinent
     * @apiGroup Continent
     * @apiDescription Find a continent by its name
     *
     * @apiParam {String} name The name of the continent
     *
     * @apiSuccess {Continent} continent The continent found
     */
    @RequestMapping("/continent/{name}")
    public Continent getContinent(@PathVariable String name) {
        return continentService.findContinentByName(name);
    }

    /**
     * @api {get} /countries/{name}
     * @apiSampleRequest /countries/Asie
     * @apiParamExample {json} Request-Example:
     *     {
     *       "name" : [{"Asie"}, {"Europe"}]
     *     }
     * @apiName findCountriesOfContinent
     * @apiGroup Continent
     * @apiDescription Find countries of a continent
     *
     * @apiParam {String} name The name of the continent
     *
     * @apiSuccess {Country[]} countries All countries of a continent
     */
    @RequestMapping("/countries/{name}")
    public List<Country> findCountriesOfContinent(@PathVariable String name) { return  continentService.findCountriesOfContinent(name); }

    /**
     * @api {get} /continents
     * @apiSampleRequest /continents/
     * @apiName findAllContinents
     * @apiGroup Continent
     * @apiDescription Find all continents
     *
     * @apiSuccess {Continent[]} continents All continents
     */
    @RequestMapping("/continents")
    public Iterable<Continent> findAllContinents() { return continentService.findAllContinents(); }

}
