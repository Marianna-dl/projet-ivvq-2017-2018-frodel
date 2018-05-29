package com.frodel.services;

import com.frodel.model.*;
import com.frodel.repositories.CityRepository;
import com.frodel.repositories.ContinentRepository;
import com.frodel.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
    private ContinentRepository continentRepository;
    @Autowired
    private PlaceService placeService;



    private Continent europe;
    private Continent asie;

    private Country japan;
    private Country ireland;

    private City tokyo;
    private City kyoto;
    private City dublin;
    private City galway;

    private  Article articleJapan;
    private Article articleIrelande;

    private Place tokyoPlace;
    private Place kyotoPlace;
    private Place dublinPlace;
    private Place galwayPlace;


    public void initData() {
        initContinent();
        initCountries();
        initCities();
        initPlaces();
        initPrincipalArticles();
        initUsers();
        initTravels();

    }

    private void initPlaces() {
        initJapanPlaces();
        initIrelandPlaces();
    }

    private void initIrelandPlaces() {
        dublinPlace = new Place();
        dublinPlace.setContinent(europe);
        dublinPlace.setCity(dublin);
        dublinPlace.setCountry(ireland);
        placeService.savePlace(dublinPlace);

        galwayPlace = new Place();
        galwayPlace.setContinent(europe);
        galwayPlace.setCity(galway);
        galwayPlace.setCountry(ireland);
        placeService.savePlace(galwayPlace);
    }

    private void initJapanPlaces() {
        tokyoPlace = new Place();
        tokyoPlace.setContinent(asie);
        tokyoPlace.setCity(tokyo);
        tokyoPlace.setCountry(japan);
        placeService.savePlace(tokyoPlace);

        kyotoPlace = new Place();
        kyotoPlace.setContinent(asie);
        kyotoPlace.setCity(kyoto);
        kyotoPlace.setCountry(japan);
        placeService.savePlace(kyotoPlace);

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
        initCityTokyo();
        initCityKyoto();
        initCityDublin();
        initCityGalway();
    }

    private void initCountries() {
        initCountryJapan();
        initCountryIreland();
    }


    private void initPrincipalArticles() {
        initArticleJapan();
        initArticleIreland();
    }

    private void initArticleIreland() {
        articleIrelande = new Article();
        articleIrelande.setName("Mon voyage en Irelande");
        articleIrelande.setStartDate(new Date(2018, 1, 1));
        articleIrelande.setEndDate(new Date(2018, 2, 1));
        articleIrelande.setContent("Mon fabuleux voyage en Irelande où j'ai vu des lieux extraordinaires avec des gens super sympa, j'y retournerai c'est sûr !!! ");
        articleIrelande.setBudget(1200l);

        articleIrelande.setPlaces(Arrays.asList(dublinPlace, galwayPlace));
    }

    private void initArticleJapan() {
        articleJapan = new Article();
        articleJapan.setName("Mon voyage au japon");
        articleJapan.setStartDate(new Date(2018, 5, 1));
        articleJapan.setEndDate(new Date(2018, 5, 10));
        articleJapan.setContent("Mon fabuleux voyage au Japon où j'ai vu des lieux extraordinaires avec des gens super sympa, j'y retournerai c'est sûr !!! ");
        articleJapan.setBudget(1500l);
        articleJapan.setPlaces(Arrays.asList(tokyoPlace, kyotoPlace));
    }

    private void initContinent() {
        initContinentAsie();
        initContinentEurope();
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
        irelandTravel.setPrincipalArticle(articleIrelande);
        travelService.saveTravel(irelandTravel);
    }

    private void initTravelJapan() {
        japanTravel = new Travel();
        japanTravel.setName("Japan");
        japanTravel.setCreator(totoUser);
        japanTravel.setPrincipalArticle(articleJapan);
        travelService.saveTravel(japanTravel);
    }

    private void initCityTokyo()
    {
        tokyo = new City();
        tokyo.setName("Tokyo");
        cityRepository.save(tokyo);
    }

    private void initCityKyoto()
    {
        kyoto = new City();
        kyoto.setName("Kyoto");
        cityRepository.save(kyoto);
    }

    private void initCountryJapan()
    {
        japan = new Country();
        japan.setName("Japon");
        List<City> cities = new ArrayList<>();
        cities.add(tokyo);
        cities.add(kyoto);
        japan.setCities(cities);
        countryRepository.save(japan);
    }

    public Travel getJapanTravel() {
        return japanTravel;
    }

    private void initCityDublin()
    {
        dublin = new City();
        dublin.setName("Dublin");
        cityRepository.save(dublin);
    }

    private void initCityGalway()
    {
        galway = new City();
        galway.setName("Galway");
        cityRepository.save(galway);
    }

    private void initCountryIreland()
    {
        ireland = new Country();
        ireland.setName("Irelande");
        List<City> cities = new ArrayList<>();
        cities.add(dublin);
        cities.add(galway);
        ireland.setCities(cities);
        countryRepository.save(ireland);
    }

    private void initContinentAsie()
    {
        asie = new Continent();
        asie.setName("Asie");
        List<Country> countries = new ArrayList<>();
        countries.add(japan);
        asie.setCountries(countries);
        continentRepository.save(asie);
    }

    private void initContinentEurope()
    {
        europe = new Continent();
        europe.setName("Europe");
        List<Country> countries = new ArrayList<>();
        countries.add(ireland);
        europe.setCountries(countries);
        continentRepository.save(europe);
    }

    public Article getArticleJapan() {
        return articleJapan;
    }

    public Travel getIrelandTravel() {
        return irelandTravel;
    }
}
