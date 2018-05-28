package com.frodel.model

import com.frodel.model.Travel
import spock.lang.Specification
import spock.lang.Unroll

import javax.validation.Validation
import javax.validation.Validator
import javax.validation.ValidatorFactory

/**
 * Created by leafo on 30/03/2018.
 */
class TravelTest extends Specification {

    Validator validator

    void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Unroll
    void "test if a travel is correct"(String aName) {

        given: "a correctly initialized travel"
        Travel travel = new Travel(name: aName, principalArticle : Mock(Article))

        expect: "The travel is valid"
        validator.validate(travel).empty

        and : "The travel as a principal article"
        travel.principalArticle != null

        and : "The travel has no other articles"
        travel.steps != null
        travel.steps.size()== 0

        where:
        aName | _
        "Travel1" | _
        "trav" | _
        "étape" | _
    }

    @Unroll
    void "test if a travel is incorrect"(String aName, Article anArticle) {

        given: "an incorrectly initialized travel"
        Travel travel = new Travel(name: aName, principalArticle: anArticle)

        expect: "The travel is invalid"
        !validator.validate(travel).empty

        where:
        aName | anArticle
        "" | Mock(Article)
        "tr" | Mock(Article)
        null | Mock(Article)
        "Travel1" | null
    }

}
