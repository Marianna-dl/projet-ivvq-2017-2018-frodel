package com.frodel.controller;

import com.frodel.model.Article;
import com.frodel.model.Place;
import com.frodel.model.Travel;
import com.frodel.repositories.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

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
    public Travel addTravel(@RequestParam(value = "name") String name, @RequestParam(value = "travelBudget") String travelBudget,
                            @RequestParam(value = "travelStartDate") Date travelStartDate, @RequestParam(value = "travelEndDate") Date travelEndDate,
                            @RequestParam(value = "travelDescription") String travelDescription, @RequestParam(value = " travelPlaces") List<Place> places ) {

        Article principalArticle = new Article();
        principalArticle.setBudget(Long.parseLong(travelBudget)   );
        principalArticle.setPlaces(places);
        principalArticle.setContent(travelDescription);
        principalArticle.setEndDate(travelEndDate);
        principalArticle.setStartDate(travelStartDate);
        principalArticle.setName(name);


        Travel travel = new Travel();
        travel.setPrincipalArticle(principalArticle);
        travel.setName(name);
        travelRepository.save(travel);
        return travel;
    }

}
