package com.frodel.services

import com.frodel.TravexApplication
import com.frodel.model.Comment
import com.frodel.model.User
import com.frodel.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import javax.validation.ConstraintViolationException

/**
 * Created by hichem on 13/04/2018.
 */
@ContextConfiguration
@SpringBootTest(classes = TravexApplication.class,webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserServiceITest extends Specification{
    @Autowired UserService utilisateurService
    @Autowired InitialisationService initialisationService

    def "test save a valid user"() {
        given: "valid user"
        User bob = new User(pseudo:"frodel",mdp:"frodelMdp",email:"frodel@frodel.fr",comments: Arrays.asList())

        when: "the user is Saved"
        utilisateurService.saveUser(bob);

        then: "the user has an id"
        bob.id != null

    }

    def "test sauvegard invalid user"() {
        given: "invalid user"
        User bob = new User(pseudo:null,mdp:"frodelMdp",email:"frodel@frodel.fr",comments: null)

        when: "the user is saved"
        utilisateurService.saveUser(bob);

        then: "thrown Exception"
        thrown ConstraintViolationException

        and: "user has still null id"
        bob.id == null
    }

    def "test find a valid user by its id"() {
        given: "a previous saved user"
        User user = initialisationService.totoUser

        when: "the user is found"
        User userFound = utilisateurService.findOneUser(user.id)

        then: "the user found has the same pseudo"
        userFound.pseudo == user.pseudo

        and: "the user has a same id"
        userFound.id == user.id
    }

}
