package com.frodel.controller;

import com.frodel.model.Travel;
import com.frodel.model.User;
import com.frodel.services.TravelService;
import com.frodel.services.UserService;
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
    private TravelService travelService;

    @Autowired
    private UserService userService;

    /**
     * @api {post} /travel/
     * @apiName addTravel
     * @apiGroup Travel
     * @apiDescription Add a travel
     *
     * @apiParam {String} name The name of travel
     * @apiParam {String} idCreator The id of the user who created the travel
     *
     * @apiSuccess {Travel} travel The new travel
     */
    @RequestMapping(value = "/travel", method = RequestMethod.POST)
    public Travel addTravel(@RequestParam(value = "name") String name, @RequestParam(value = "idCreator") String idCreator) {

        User creator = userService.findOneUser(Long.parseLong(idCreator));
        Travel travel = new Travel();
        travel.setName(name);
        travel.setCreator(creator);
        return travelService.saveTravel(travel);
    }

}
