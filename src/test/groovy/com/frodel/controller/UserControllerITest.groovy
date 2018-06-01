package com.frodel.controller

import com.frodel.TravexApplication
import com.frodel.model.User
import com.frodel.services.InitialisationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.ContextConfiguration
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import spock.lang.Specification

/**
 * Created by hichem on 13/04/2018.
 */
@ContextConfiguration
@SpringBootTest(classes = TravexApplication.class,webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerITest extends Specification{
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private InitialisationService initialisationService;

    void "test ajout d'un utilisateur"(String pseudo,String mdp,String email) {

        when: "un ajout d'utilisateur est demandé"
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("pseudo", pseudo);
        map.add("mdp", mdp);
        map.add("email", email);
        User utilisateur = restTemplate.postForObject("/inscriptions",map, User.class)

        then: "le retour fournit les informations de l'utilisateur créé"
        utilisateur.pseudo == pseudo
        utilisateur.mdp == mdp
        utilisateur.email == email
        where:
        pseudo   | mdp       | email
        "frodel" | "frodeltest"  | "frodel@frodel.fr"
    }

    def "test to find a user with a given pseudo calling url"() {
        given: "a user pseudo"
        String pseudo = initialisationService.totoUser.pseudo

        when: "find user by pseudo requested"
        String body = this.restTemplate.getForObject("/user/userPseudo/" + pseudo, String.class);

        then:"the result provides 1 user"
        body.contains(initialisationService.totoUser.pseudo)
    }

    def "test to find all users by calling url"() {

        when: "find Users requested"
        String body = this.restTemplate.getForObject("/users", String.class);

        then:"the result provides 2 users"
        body.contains(initialisationService.totoUser.pseudo)
        body.contains(initialisationService.titiUser.pseudo)
    }

}
