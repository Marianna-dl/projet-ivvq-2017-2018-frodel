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
    void "test if a user is correct"(String pseudo, String mdp, String email, List<Comment> comments, List<Question> questions, List<Answer> answers) {

        given: "a correctly initialized user"
        User utilisateur = new User(pseudo:pseudo,mdp: mdp,email:email, comments: comments, questions: questions, answers: answers )

        expect: "The user is valid"
        validator.validate(utilisateur).empty

        and : "he has no travels"
        !utilisateur.travels

        where:
        pseudo   | mdp              | email         |comments                                     | questions                                     | answers
        "Dupont" | "azertyuiop"     | "jd@jd.com"   | Arrays.asList(Mock(Comment), Mock(Comment)) | Arrays.asList(Mock(Question), Mock(Question)) | Arrays.asList(Mock(Answer), Mock(Answer))
        "Durand" | "12zfov86§ju"    | "jd@jd.com"   | Arrays.asList(Mock(Comment))                | Arrays.asList(Mock(Question), Mock(Question)) | Arrays.asList(Mock(Answer), Mock(Answer))
        "Durant" | "JacquesJacques" | "jd@jd.com"   | null                                        | Arrays.asList(Mock(Question), Mock(Question)) | Arrays.asList(Mock(Answer), Mock(Answer))
        "Dupont" | "azertyuiop"     | "jd@jd.com"   | Arrays.asList(Mock(Comment), Mock(Comment)) | Arrays.asList(Mock(Question)) | Arrays.asList(Mock(Answer), Mock(Answer))
        "Dupont" | "azertyuiop"     | "jd@jd.com"   | Arrays.asList(Mock(Comment), Mock(Comment)) | null | Arrays.asList(Mock(Answer), Mock(Answer))
        "Dupont" | "azertyuiop"     | "jd@jd.com"   | Arrays.asList(Mock(Comment), Mock(Comment)) | Arrays.asList(Mock(Question), Mock(Question)) | Arrays.asList(Mock(Answer))
        "Dupont" | "azertyuiop"     | "jd@jd.com"   | Arrays.asList(Mock(Comment), Mock(Comment)) | Arrays.asList(Mock(Question), Mock(Question)) | null
    }



    @Unroll
    void "test if a user is incorrect"(String pseudo, String mdp, String email,List<Comment> comments, List<Question> questions, List<Answer> answers) {

        given: "an incorrectly initialized user"
        User utilisateur = new User(pseudo:pseudo,mdp:mdp,email:email,comments: comments, questions: questions, answers: answers)

        expect: "The user is invalid"
        !validator.validate(utilisateur).empty

        where:
        pseudo      | mdp               | email             |comments                                    | questions                                    | answers
        ""          | "azertyuiop"      | "jd@jd.com"       |Arrays.asList(Mock(Comment), Mock(Comment)) |Arrays.asList(Mock(Question), Mock(Question)) |Arrays.asList(Mock(Answer), Mock(Answer))
        "Durand1"   | ""                | "jd@jd.com"       |null                                        | new ArrayList<>()                            | new ArrayList<>()
        "Durant1"   | "JacquesJacques"  | ""                |Arrays.asList(Mock(Comment))                | new ArrayList<>()                            | new ArrayList<>()
        null        | "azertyuiop"      | "jd@jd.com"       |new ArrayList<>()                           | new ArrayList<>()                            | new ArrayList<>()
        "Durand2"   | null              | "jd@jd.com"       |new ArrayList<>()                           | new ArrayList<>()                            | new ArrayList<>()
        "Durant2"   | "JacquesJacques"  | null              |new ArrayList<>()                           | new ArrayList<>()                            | new ArrayList<>()
        "Durand3"   | "123"             | "jd@jd.com"       |new ArrayList<>()                           | new ArrayList<>()                            | new ArrayList<>()
        "Durant3"   | "JacquesJacques"  | "emailnonvalide"  |new ArrayList<>()                           | new ArrayList<>()                            | new ArrayList<>()
    }
}
