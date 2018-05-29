package com.frodel.services

import com.frodel.model.Place
import com.frodel.repositories.PlaceRepository
import org.springframework.data.repository.PagingAndSortingRepository
import spock.lang.Specification

class PlaceServiceTest extends Specification{

    PlaceService placeService
    PlaceRepository placeRepository


    void setup() {
        placeRepository = Mock()
        placeService = new PlaceService()
        placeService.placeRepository = placeRepository
    }

    def "check type of placeRepository"() {
        expect: "placeRepository is a Spring repository"
        placeRepository instanceof PagingAndSortingRepository
    }

    def "test delegation of save of an place to the repository"() {
        given: "a place"
        def place = Mock(Place)

        when: "the place is saved"
        placeService.savePlace(place);

        then: "the save is delegated to the placeRepository"
        1 * placeRepository.save(place)
    }
}
