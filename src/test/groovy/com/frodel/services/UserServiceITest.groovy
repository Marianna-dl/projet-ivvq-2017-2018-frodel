package com.frodel.services

import com.frodel.Bootstrap
import com.frodel.TravexApplication
import com.frodel.model.User
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
    @Autowired UserService userService
    @Autowired InitialisationService initialisationService
    @Autowired Bootstrap bootstrap
    def "test save a valid user"() {
        given: "valid user"
        User bob = new User(pseudo:"frodel",mdp:"frodelMdp",email:"frodel@frodel.fr",comments: Arrays.asList())

        when: "the user is Saved"
        userService.saveUser(bob);

        then: "the user has an id"
        bob.id != null

    }

    def "test sauvegard invalid user"() {
        given: "invalid user"
        User bob = new User(pseudo:null,mdp:"frodelMdp",email:"frodel@frodel.fr",comments: null)

        when: "the user is saved"
        userService.saveUser(bob);

        then: "thrown Exception"
        thrown ConstraintViolationException

        and: "user has still null id"
        bob.id == null
    }

    def "test find a valid user by its id"() {
        given: "a previous saved user"
        User user = initialisationService.totoUser

        when: "the user is found"
        User userFound = userService.findOneUser(user.id)

        then: "the user found has the same pseudo"
        userFound.pseudo == user.pseudo

        and: "the user has a same id"
        userFound.id == user.id
    }

    def "test finding a user by pseudo"() {
        given: "The instance of InitialisationService provided by the bootstrap object"
        InitialisationService initialisationService = bootstrap.initialisationService


        and: "1 user pseudo provided by the initialisation service"
        String pseudo = initialisationService.totoUserPseudo

        when: "requesting a user"
        User user = userService.findUserByPseudo(pseudo)

        then : "the user is the same given by the initialisation service"
        user.pseudo == initialisationService.totoUserPseudo
    }

    def "test getting all users"() {
        given: "The instance of InitialisationService provided by the bootstrap object"
        InitialisationService initialisationService = bootstrap.initialisationService

        and: "2 users provided by the initialisation service"
        initialisationService.totoUser
        initialisationService.titiUser

        when: "requesting all users"
        Iterable<User> usersIter = userService.findAllUsers()
        def users = usersIter as List<User>

        then : "the users are the same given by the initialisation service"
        users[0].pseudo == initialisationService.titiUser.pseudo
        users[1].pseudo == initialisationService.totoUser.pseudo
    }

}
