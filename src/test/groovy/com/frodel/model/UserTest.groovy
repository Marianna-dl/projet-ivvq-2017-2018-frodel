package com.frodel.model

import com.frodel.model.User
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

        and : "he has no travels"
        !utilisateur.travels

        where:
        pseudo   | mdp       | email
        "Dupont" | "azertyuiop"  | "jd@jd.com"
        "Durand" | "12zfov86§ju" | "jd@jd.com"
        "Durant" | "JacquesJacques" | "jd@jd.com"
    }



    @Unroll
    void "test la validite d'un utilisateur non valide"(String pseudo, String mdp, String email) {

        given: "un utilisateur initialise correctement"
        User utilisateur = new User(pseudo,mdp,email)

        expect: "l'utilisateur est valide"
        !validator.validate(utilisateur).empty

        where:
        pseudo   | mdp       | email
        "" | "azertyuiop"  | "jd@jd.com"
        "Durand1" | "" | "jd@jd.com"
        "Durant1" | "JacquesJacques" | ""
        null | "azertyuiop"  | "jd@jd.com"
        "Durand2" | null | "jd@jd.com"
        "Durant2" | "JacquesJacques" | null
        "Durand3" | "123" | "jd@jd.com"
        "Durant3" | "JacquesJacques" | "emailnonvalide"
    }
}
