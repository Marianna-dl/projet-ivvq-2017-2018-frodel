package com.frodel.controller;

import com.frodel.model.City;
import com.frodel.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by leafo on 29/05/2018.
 */
@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    /**
     * @api {get} /city/{name}
     * @apiName findCityByName
     * @apiGroup City
     * @apiDescription Find a city by its name
     *
     * @apiParam {String} name The name of city
     *
     * @apiSuccess {City} city The city found
     */
    @RequestMapping("/city/{name}")
    public City findCityByName(@PathVariable String name) {
        return cityService.findCityByName(name);
    }
}
