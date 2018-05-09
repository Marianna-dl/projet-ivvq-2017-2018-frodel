package com.frodel.services;

import com.frodel.model.City;
import com.frodel.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;


    /**
     * Save the given city
     *
     * @param city the city
     * @return the saved city
     */
    public City saveCity(City city) {
        return cityRepository.save(city);
    }


}
