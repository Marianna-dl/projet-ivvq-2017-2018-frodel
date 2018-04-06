package com.frodel

import org.springframework.boot.test.context.SpringBootTest


/**
 * Created by hichem on 30/03/2018.
 */

import spock.lang.Specification
import spock.lang.Unroll

import javax.validation.Validation
import javax.validation.Validator
import javax.validation.ValidatorFactory

@SpringBootTest
class UserTest extends Specification {

    Validator validator

    void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Unroll
    void "test la validite d'un utilisateur valide"(String pseudo, String mdp, String email) {

        given: "un utilisateur initialise correctement"
        User utilisateur = new User(pseudo,mdp,email)

        expect: "l'utilisateur est valide"
        validator.validate(utilisateur).empty

        where:
        pseudo   | mdp       | email
        "Dupont" | "Jeanne"  | "jd@jd.com"
        "Durand" | "Jacques" | "jd@jd.com"
        "Durand" | "Jacques" | "jd@jd.com"
    }
   /* def "save user"(){
        given: "a valid utilisateur"
        User bob = new User("frodel", "frodelmdp", "frodel@frodel.fr")

        when: "the utilisateur is saved"
        userService.saveUtilisateur(bob);

        then: "the utilisateur has an id"
        bob.id != null
    }*/
}
