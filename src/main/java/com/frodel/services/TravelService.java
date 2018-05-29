package com.frodel.services;

import com.frodel.model.Travel;
import com.frodel.model.User;
import com.frodel.repositories.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Marianna on 13/04/2018.
 */
@Service
public class TravelService {

    @Autowired
    private TravelRepository travelRepository;

    /**
     * Save the given travel
     * @param travel the travel
     * @return the saved travel
     */
    public Travel saveTravel(Travel travel) {

        travelRepository.save(travel);
        User creator = travel.getCreator();
        creator.getTravels().add(travel);

        return travel ;
    }
}
