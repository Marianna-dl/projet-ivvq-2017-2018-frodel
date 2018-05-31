package com.frodel.services;

import com.frodel.model.Article;
import com.frodel.model.Travel;
import com.frodel.model.User;
import com.frodel.repositories.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marianna on 13/04/2018.
 */
@Service
public class TravelService {

    @Autowired
    private TravelRepository travelRepository;

    /**
     * Save the given travel
     * @param travel the travel
     * @return the saved travel
     */
    public Travel saveTravel(Travel travel) {

        travelRepository.save(travel) ;
        Article principalArticle = travel.getPrincipalArticle();
        principalArticle.setTravel(travel);
        if(!(travel.getSteps().isEmpty())){
            travel.getSteps().stream().forEach(step -> step.setTravel(travel));
        }
        User creator = travel.getCreator();
        creator.getTravels().add(travel);

        return travel ;
    }

    /**
     * Find all travels from database
     * @return an iterable of the travels
     */
    public Iterable<Travel> findAllTravels() {
        return travelRepository.findAll();
    }

    public Iterable<Travel>  findTravelByName(String name) {
        return travelRepository.findTravelByName(name);
    }

    public Travel findTravelById(Long id) {
        return travelRepository.findOne(id);
    }

    public Iterable<Article> findAllArticlesForTravel(Long id) {
        Travel travel = travelRepository.findOne(id);
        List<Article> articles = new ArrayList<>();
        if(travel != null){
            articles.addAll(travel.getSteps());
        }
        return articles;

    }
}
