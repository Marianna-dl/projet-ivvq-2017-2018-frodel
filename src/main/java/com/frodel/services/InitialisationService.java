package com.frodel.services;

import com.frodel.model.*;
import com.frodel.repositories.CityRepository;
import com.frodel.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class InitialisationService {

    @Autowired
    private TravelService travelService;

    @Autowired
    private UserService userService;

    private User totoUser;
    private User titiUser;

    private Travel japanTravel;
    private Travel irelandTravel;

    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private ContinentService continentService;

    private Continent eurasie;

    private Country france;
    private Country espagne;

    private City toulouse;
    private City paris;
    private City madrid;
    private City barcelone;

    public void initData() {
        initUsers();
        initTravels();
        initCities();
        initCountries();
        initContinent();
    }

    private void initUsers() {
        initTitiUser();
        initTotoUser();
    }

    private void initTravels() {
        initTravelJapan();
        initTravelIreland();
    }

    private void initCities() {
        initCityToulouse();
        initCityParis();
        initCityMadrid();
        initCityBarcelone();
    }

    private void initCountries() {
        initCountryFrance();
        initCountryEspagne();
    }

    private void initContinent() {
        initContinentEurasie();
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
        irelandTravel = new Travel();
        irelandTravel.setName("Ireland");
        irelandTravel.setCreator(titiUser);
        travelService.saveTravel(irelandTravel);
    }

    private void initTravelJapan() {
        japanTravel = new Travel();
        japanTravel.setName("Japan");
        japanTravel.setCreator(totoUser);
        travelService.saveTravel(japanTravel);
    }

    private void initCityToulouse() {
        toulouse = new City();
        toulouse.setName("Toulouse");
        cityRepository.save(toulouse);
    }

    private void initCityParis() {
        paris = new City();
        paris.setName("Paris");
        cityRepository.save(paris);
    }

    private void initCountryFrance() {
        france = new Country();
        france.setName("France");
        List<City> cities = new ArrayList<>();
        cities.add(toulouse);
        cities.add(paris);
        france.setCities(cities);
        countryRepository.save(france);
    }

    public Travel getJapanTravel() {
        return japanTravel;
    }

    private void initCityMadrid() {
        madrid = new City();
        madrid.setName("Madrid");
        cityRepository.save(madrid);
    }

    private void initCityBarcelone() {
        barcelone = new City();
        barcelone.setName("Barcelonne");
        cityRepository.save(barcelone);
    }

    private void initCountryEspagne() {
        espagne = new Country();
        espagne.setName("Espagne");
        List<City> cities = new ArrayList<>();
        cities.add(madrid);
        cities.add(barcelone);
        espagne.setCities(cities);
        countryRepository.save(espagne);
    }

    private void initContinentEurasie() {
        eurasie = new Continent();
        eurasie.setName("Eurasie");
        List<Country> countries = new ArrayList<>();
        countries.add(france);
        countries.add(espagne);
        eurasie.setCountries(countries);
        continentService.saveContinent(eurasie);
    }

    public Travel getIrelandTravel() {
        return irelandTravel;
    }

    public Continent getEurasie() {
        return eurasie;
    }
}
