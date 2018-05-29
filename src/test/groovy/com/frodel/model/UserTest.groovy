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
    void "test if a user is correct"(String pseudo, String mdp, String email, List<Comment> comments) {

        given: "a correctly initialized user"
        User utilisateur = new User(pseudo:pseudo,mdp: mdp,email:email, comments: comments)

        expect: "The user is valid"
        validator.validate(utilisateur).empty

        where:
        pseudo   | mdp              | email         |comments
        "Dupont" | "azertyuiop"     | "jd@jd.com"   | Arrays.asList(Mock(Comment), Mock(Comment))
        "Durand" | "12zfov86§ju"    | "jd@jd.com"   | Arrays.asList(Mock(Comment))
        "Durant" | "JacquesJacques" | "jd@jd.com"   | null
    }

    @Unroll
    void "test if a user is incorrect"(String pseudo, String mdp, String email,List<Comment> comments) {

        given: "an incorrectly initialized user"
        User utilisateur = new User(pseudo:pseudo,mdp:mdp,email:email,comments: comments)

        expect: "The user is invalid"
        !validator.validate(utilisateur).empty

        where:
        pseudo      | mdp               | email             |comments
        ""          | "azertyuiop"      | "jd@jd.com"       |Arrays.asList(Mock(Comment), Mock(Comment))
        "Durand1"   | ""                | "jd@jd.com"       |null
        "Durant1"   | "JacquesJacques"  | ""                |Arrays.asList(Mock(Comment))
        null        | "azertyuiop"      | "jd@jd.com"       |new ArrayList<>()
        "Durand2"   | null              | "jd@jd.com"       |new ArrayList<>()
        "Durant2"   | "JacquesJacques"  | null              |new ArrayList<>()
        "Durand3"   | "123"             | "jd@jd.com"       |new ArrayList<>()
        "Durant3"   | "JacquesJacques"  | "emailnonvalide"  |new ArrayList<>()
    }
}
