package com.frodel.services

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
    @Autowired UserService utilisateurService

    def "test sauvegarder un utilisateur valide"() {
        given: "valide utilisateur"
        User bob = new User("frodel","frodelMdp","frodel@frodel.fr")

        when: "l'utilisateur est enregistré"
        utilisateurService.saveUser(bob);

        then: "l'utilisateur à un id"
        bob.id != null

    }

    def "test sauvegarder un utilisateur non valide"() {
        given: "non valide utilisateur"
        User bob = new User(null,"frodelMdp","frodel@frodel.fr")

        when: "l'utilisateur est anregistré"
        utilisateurService.saveUser(bob);

        then: "une exception est levée"
        thrown ConstraintViolationException

        and: "bob has still null id"
        bob.id == null
    }

}
