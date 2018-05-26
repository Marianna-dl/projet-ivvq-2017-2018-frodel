package com.frodel.services;

import com.frodel.model.City;
import com.frodel.model.Continent;
import com.frodel.model.Country;
import com.frodel.repositories.CityRepository;
import com.frodel.repositories.ContinentRepository;
import com.frodel.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Bootstrap of the application
 */
@Service
@Transactional
public class InitialisationServices {

    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private ContinentRepository continentRepository;

    private Continent eurasie;

    private Country france;
    private Country espagne;

    private City toulouse;
    private City paris;
    private City madrid;
    private City barcelone;

    public void initCountries() {
        initAndSaveToulouse();
        initAndSaveParis();
        initAndSaveFrance();

        initAnsSaveMadrid();
        initAndSaveBarcelone();
        initAndSaveEspagne();

        initAndSaveEurasie();
    }

    private void initAndSaveToulouse()
    {
        toulouse = new City();
        toulouse.setName("Toulouse");
        cityRepository.save(toulouse);
    }

    private void initAndSaveParis()
    {
        paris = new City();
        paris.setName("Paris");
        cityRepository.save(paris);
    }

    private void initAndSaveFrance()
    {
        france = new Country();
        france.setName("France");
        List<City> cities = new ArrayList<>();
        cities.add(toulouse);
        cities.add(paris);
        france.setCities(cities);
        countryRepository.save(france);
    }

    private void initAnsSaveMadrid()
    {
        madrid = new City();
        madrid.setName("Madrid");
        cityRepository.save(madrid);
    }

    private void initAndSaveBarcelone()
    {
        barcelone = new City();
        barcelone.setName("Barcelonne");
        cityRepository.save(barcelone);
    }

    private void initAndSaveEspagne()
    {
        espagne = new Country();
        espagne.setName("Espagne");
        List<City> cities = new ArrayList<>();
        cities.add(madrid);
        cities.add(barcelone);
        espagne.setCities(cities);
        countryRepository.save(espagne);
    }

    private void initAndSaveEurasie()
    {
        eurasie = new Continent();
        eurasie.setName("Eurasie");
        List<Country> countries = new ArrayList<>();
        countries.add(france);
        countries.add(espagne);
        eurasie.setCountries(countries);
        continentRepository.save(eurasie);
    }

    public Continent getEurasie() {
        return eurasie;
    }

    public Country getFrance() {
        return france;
    }

    public Country getEspagne() {
        return espagne;
    }

    public City getToulouse() {
        return toulouse;
    }

    public City getParis() {
        return paris;
    }

    public City getMadrid() {
        return madrid;
    }

    public City getBarcelone() {
        return barcelone;
    }
}