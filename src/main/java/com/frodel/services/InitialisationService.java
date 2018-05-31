package com.frodel.services;

import com.frodel.model.*;

import com.frodel.repositories.CityRepository;
import com.frodel.repositories.CommentRepository;
import com.frodel.repositories.ContinentRepository;
import com.frodel.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class InitialisationService {

    @Autowired
    private TravelService travelService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    private User totoUser;
    private User titiUser;

    private Travel japanTravel;
    private Comment totoComment;

    private Comment titiComment;
    private Travel irelandTravel;

    @Autowired
    private CityService cityService;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private ContinentRepository continentRepository;
    @Autowired
    private PlaceService placeService;

    @Autowired
    private CommentRepository commentRepository;


    private Continent europe;
    private Continent asie;

    private Country japan;
    private Country ireland;

    private City tokyo;
    private City kyoto;
    private City dublin;
    private City galway;

    private Article articleJapan;
    private Article articleJapanStep1;
    private Article articleIrelande;

    private Place tokyoPlace;
    private Place kyotoPlace;
    private Place dublinPlace;
    private Place galwayPlace;

    private String japanTravelName = "Japan";

    private String totoUserPseudo = "toto";

    public Article getArticleJapanStep1() {
        return articleJapanStep1;
    }

    public String getJapanTravelName() {
        return japanTravelName;
    }

    public String getTotoUserPseudo() {return totoUserPseudo;}

    public Article getArticleJapan() {
        return articleJapan;
    }

    public Article getArticleIrelande() {
        return articleIrelande;
    }

    public Continent getAsie() {
        return asie;
    }

    public Country getJapan() {
        return japan;
    }

    public City getTokyo() {
        return tokyo;
    }

    public void initData() {
        initContinent();
        initCountries();
        initCities();
        initPlaces();
        initPrincipalArticles();
        initJapanSteps();
        initUsers();
        initTravels();
        initComments();

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

    private void initComments(){
        initTotoComment();
        initTitiComment();
    }

    private void initJapanSteps(){
        initJapanArticleStep1();
    }

    private void initJapanArticleStep1() {
        Place place = new Place();
        place.setContinent(asie);
        place.setCity(tokyo);
        place.setCountry(japan);
        placeService.savePlace(place);

        articleJapanStep1 = new Article();
        articleJapanStep1.setName("Première étape : Tokyo !");
        articleJapanStep1.setStartDate(new GregorianCalendar(2018, 5, 1).getTime());
        articleJapanStep1.setEndDate(new GregorianCalendar(2018, 5, 3).getTime());
        articleJapanStep1.setContent("Ma première étape (3 jours), a été de visiter la superbe ville de Tokyo. A un prix raisonnable, on peut acheter des trucs intéressants ! ");
        articleJapanStep1.setBudget(200l);
        articleJapanStep1.setPlaces(Arrays.asList(place));
    }

    private void initArticleIreland() {
        articleIrelande = new Article();
        articleIrelande.setName("Mon voyage en Irelande");
        articleIrelande.setStartDate(new GregorianCalendar(2018, 1, 1).getTime());
        articleIrelande.setEndDate(new GregorianCalendar(2018, 2, 1).getTime());
        articleIrelande.setContent("Mon fabuleux voyage en Irelande où j'ai vu des lieux extraordinaires avec des gens super sympa, j'y retournerai c'est sûr !!! ");
        articleIrelande.setBudget(1200l);

        articleIrelande.setPlaces(Arrays.asList(dublinPlace, galwayPlace));
    }

    private void initArticleJapan() {
        articleJapan = new Article();
        articleJapan.setName("Mon voyage au japon");
        articleJapan.setStartDate(new GregorianCalendar(2018, 5, 1).getTime());
        articleJapan.setEndDate(new GregorianCalendar(2018, 5, 10).getTime());
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

    public void initTravelJapan() {
        japanTravel = new Travel();
        japanTravel.setName("Japan");
        japanTravel.setCreator(totoUser);
        japanTravel.setPrincipalArticle(articleJapan);
        japanTravel.getSteps().add(articleJapanStep1);
        travelService.saveTravel(japanTravel);
    }

    public void initTotoComment() {
        totoComment = new Comment();
        totoComment.setTitle("toto comment");
        totoComment.setCommentator(totoUser);
        totoComment.setMark((long) 5);
        totoComment.setContent("c'est un comment");
        commentService.saveComment(totoComment);
    }

    public void initTitiComment() {
        titiComment = new Comment();
        titiComment.setTitle("titi comment");
        titiComment.setCommentator(titiUser);
        titiComment.setMark((long) 1);
        titiComment.setContent("c'est un comment de titi");
        commentService.saveComment(titiComment);
    }

    private void initCityTokyo()
    {
        toulouse = new City();
        toulouse.setName("Toulouse");
        cityService.saveCity(toulouse);
        tokyo = new City();
        tokyo.setName("Tokyo");
        cityRepository.save(tokyo);
    }

    private void initCityKyoto()
    {
        paris = new City();
        paris.setName("Paris");
        cityService.saveCity(paris);
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
        madrid = new City();
        madrid.setName("Madrid");
        cityService.saveCity(madrid);
        dublin = new City();
        dublin.setName("Dublin");
        cityRepository.save(dublin);
    }

    private void initCityGalway()
    {

        barcelone = new City();
        barcelone.setName("Barcelone");
        cityService.saveCity(barcelone);
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


    public Travel getIrelandTravel() {
        return irelandTravel;
    }
    public City getMadrid() {
        return madrid;
    }
}
    public User getTotoUser() {
        return totoUser;
    }
    public Comment getTotoComment() {return totoComment;}
    public Comment getTitiComment() {return titiComment;}

    public User getTitiUser() {return titiUser;}
}
