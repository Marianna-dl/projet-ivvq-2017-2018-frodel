package com.frodel.controller;


import com.frodel.model.Travel;

import com.frodel.services.TravelService;
import com.frodel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Controller of a travel
 */
@RestController
public class TravelController {

    @Autowired
    private TravelService travelService;

    @Autowired
    private UserService userService;

    /**
     * @api {get} /travels/
     * @apiName findAllTravels
     * @apiGroup Travel
     * @apiDescription find all travels
     *
     *
     * @apiSuccess {Iterable<Travel>} the list of travels
     */
    @RequestMapping("/travels")
    public Iterable<Travel> findAllTravels() {
        return travelService.findAllTravels();
    }


}
