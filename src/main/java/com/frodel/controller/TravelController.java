package com.frodel.controller;

import com.frodel.model.Travel;
import com.frodel.repositories.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller of a travel
 */
@RestController
public class TravelController {

    @Autowired
    private TravelRepository travelRepository;

    /**
     * @api {post} /travel/
     * @apiName addTravel
     * @apiGroup Travel
     * @apiDescription Add a travel
     *
     * @apiParam {String} name The name of travel
     *
     * @apiSuccess {Travel} travel The new travel
     */
    @RequestMapping(value = "/travel", method = RequestMethod.POST)
    public Travel addTravel(@RequestParam(value = "name") String name) {
        Travel travel = new Travel();
        travel.setName(name);
        travelRepository.save(travel);
        return travel;
    }

}
