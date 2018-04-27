package com.frodel.services;

import com.frodel.model.Travel;
import com.frodel.repositories.TravelRepository;

/**
 * Created by Marianna on 13/04/2018.
 */
public class TravelService {


    private TravelRepository travelRepository;

    /**
     * Save the given travel
     * @param travel the travel
     * @return the saved travel
     */
    public Travel saveTravel(Travel travel) {
        return travelRepository.save(travel) ;
    }
}
