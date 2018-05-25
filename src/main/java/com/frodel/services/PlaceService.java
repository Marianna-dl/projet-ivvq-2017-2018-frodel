package com.frodel.services;

import com.frodel.model.Place;
import com.frodel.repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    /**
     * Save the given place
     *
     * @param place the place
     * @return the saved place
     */
    public Place savePlace(Place place) {
        return placeRepository.save(place);
    }
}
