package com.frodel.services

import com.frodel.Bootstrap
import com.frodel.TravexApplication
import com.frodel.model.Travel
import com.frodel.model.User
import com.frodel.services.TravelService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import javax.transaction.Transactional

/**
 * Created by Marianna on 27/04/2018.
 */
@ContextConfiguration
@SpringBootTest(classes = TravexApplication.class ,webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
class TravelServiceITest extends Specification{

    @Autowired TravelService travelService
    @Autowired Bootstrap bootstrap

    def "test save a valid travel"() {
        given: "a valid user"
        User user = new User(pseudo : "Dupont" , mdp : "azertyuiop"  , email : "jd@jd.com");

        and : "a valid travel"
        Travel travel = new Travel(name: "Mon voyage au Japon", creator : user)

        when: "the travel is saved"
        travelService.saveTravel(travel);

        then: "the travel has an id"
        travel.id != null

        and: "the user has an id"
        user.id != null

        and : "the user has a travel"
        user.travels.size() == 1
        user.travels.first().name == travel.name
    }


    def "test getting all travels"() {
        given: "The instance of InitialisationService provided by the bootstrap object"
        InitialisationService initialisationService = bootstrap.initialisationService

        and: "2 travels provided by the initialisation service"
        initialisationService.japanTravel
        initialisationService.irelandTravel

        when: "requesting all travels"
        Iterable<Travel> travelsIter = travelService.findAllTravels()
        def travels = travelsIter as List<Travel>

        then : "the travel are the same given by the initialisation service"
        travels[0].name == initialisationService.japanTravel.name
        travels[1].name == initialisationService.irelandTravel.name
    }





}
