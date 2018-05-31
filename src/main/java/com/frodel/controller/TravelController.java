package com.frodel.controller;


import com.frodel.model.Article;
import com.frodel.model.Travel;

import com.frodel.services.TravelService;
import com.frodel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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

    /**
     * @api {get} /travel/name/:travelName
     * @apiName findAllTravelsByName
     * @apiGroup Travel
     * @apiDescription find all travels with a given name
     *
     * @apiParam {String} travelName The name of searched travel
     * @apiSuccess {Iterable<Travel>} the list of travels
     */
    @RequestMapping("/travel/name/{travelName}")
    public Iterable<Travel> findAllTravelsByName(@PathVariable  String travelName) {
        return travelService.findTravelByName(travelName);
    }


    /**
     * @api {get} /travel/id/:idTravel
     * @apiName findTravelById
     * @apiGroup Travel
     * @apiDescription find a travel with a given id
     *
     * @apiParam {Long} idTravel The id of searched travel
     * @apiSuccess {Travel} the travel
     */
    @RequestMapping("/travel/id/{idTravel}")
    public Travel findTravelById(@PathVariable Long idTravel) {
        return travelService.findTravelById(idTravel);
    }

    /**
     * @api {get} /travel/articles/:idTravel
     * @apiName findAllArticles
     * @apiGroup Travel
     * @apiDescription find all articles of a travel with a given travel id
     *
     * @apiParam {Long} idTravel The id of the travel
     * @apiSuccess {Iterable<Article>} the list of articles related to the travel
     */
    @RequestMapping("/travel/articles/{idTravel}")
    public Iterable<Article> findAllArticles(@PathVariable Long idTravel) {
        return travelService.findAllArticlesForTravel(idTravel);
    }
}
