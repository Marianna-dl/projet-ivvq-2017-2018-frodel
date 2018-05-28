package com.frodel.services;

import com.frodel.model.Travel;
import com.frodel.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class InitialisationService {

    @Autowired
    private TravelService travelService;
    @Autowired private UserService userService;

    private User totoUser;
    private User titiUser;


    public void initData(){
        initUsers();
        initTravels();
    }

    private void initTravels(){
        initTravelJapan();
        initTravelIreland();
    }

    private void initUsers(){
        initTitiUser();
        initTotoUser();
    }

    private void initTotoUser() {
        totoUser = new User();
        totoUser.setEmail("toto@gmail.com");
        totoUser.setMdp("totopassword");
        totoUser.setPseudo("toto");
        userService.saveUser(totoUser);
    }

    private void initTitiUser() {
        titiUser = new User();
        titiUser.setEmail("titi@gmail.com");
        titiUser.setMdp("titipassword");
        titiUser.setPseudo("titi");
        userService.saveUser(titiUser);
    }

    private void initTravelIreland() {
        Travel irelandTravel = new Travel();
        irelandTravel.setName("Ireland");
        irelandTravel.setCreator(titiUser);
        travelService.saveTravel(irelandTravel);
    }

    private void initTravelJapan() {
        Travel japanTravel = new Travel();
        japanTravel.setName("Japan");
        japanTravel.setCreator(totoUser);
        travelService.saveTravel(japanTravel);
    }



}
