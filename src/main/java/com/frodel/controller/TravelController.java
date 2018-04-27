package com.frodel.controller;

import com.frodel.model.Travel;
import com.frodel.repositories.TravelRepository;

/**
 * Controller of a travel
 */
public class TravelController {

    private TravelRepository travelRepository;

    /**
     * Add a travel
     *
     * @param name The name of travel
     * @return The added travel
     */
    public Travel addTravel(String name) {
        Travel travel = new Travel();
        travel.setName(name);
        travelRepository.save(travel);
        return travel;
    }

}
