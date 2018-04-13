package com.frodel.services

import com.frodel.model.Travel
import com.frodel.repositories.TravelRepository
import org.springframework.data.repository.PagingAndSortingRepository
import spock.lang.Specification

/**
 * Created by Marianna on 13/04/2018.
 */
class TravelServiceTest extends Specification{


    TravelService travelService
    TravelRepository travelRepository


    void setup() {
        travelRepository = Mock()
        travelService = new TravelService()
        travelService.travelRepository = travelRepository
    }

    def "check type of travelRepository"() {
        expect: "travelRepository is a Spring repository"
        travelRepository instanceof PagingAndSortingRepository
    }

}
