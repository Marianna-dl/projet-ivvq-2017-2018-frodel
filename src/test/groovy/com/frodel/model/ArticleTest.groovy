package com.frodel.model

import spock.lang.Specification
import spock.lang.Unroll

import javax.validation.Validation
import javax.validation.Validator
import javax.validation.ValidatorFactory

class ArticleTest extends Specification{

    Validator validator

    void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Unroll
    void "test if a article is correct"(String aName, Long aBudget, Date aStartDate, Date anEndDate, String aContent, List<Place> itsPlaces ) {

        given: "a correctly initialized article"
        Article article = new Article(name: aName, budget : aBudget, startDate : aStartDate, endDate : anEndDate, content : aContent, places : itsPlaces, isVisible : true)

        expect: "The article is valid"
        validator.validate(article).empty

        where:
        aName | aBudget | aStartDate | anEndDate | aContent | itsPlaces
        "Article" | 550.3 | new Date(2018, 1, 1) | new Date(2018, 2, 1) | "This travel was amazing ! But the content must have a size of 100 characters so we write some lines ..." | Arrays.asList(Mock(Place), Mock(Place))
        "abcd" | 1 | new Date(2018, 1, 1) | new Date(2018, 2, 1) | "This travel was amazing ! But the content must have a size of 100 characters so we write some lines ... !! " | Arrays.asList(Mock(Place))
        "étape" | 0 | new Date(2018, 1, 1) | new Date(2018, 2, 1) | "This travel was amazing ! But the content must have a size of 100 characters so we write some lines ..." | Arrays.asList(Mock(Place), Mock(Place))

    }


    @Unroll
    void "test if a article is incorrect"(String aName, Long aBudget, Date aStartDate, Date anEndDate, String aContent, List<Place> itsPlaces ) {

        given: "an incorrectly initialized article"
        Article article = new Article(name: aName, budget : aBudget, startDate : aStartDate, endDate : anEndDate, content : aContent, places : itsPlaces, isVisible : true)

        expect: "The article is not valid"
        !validator.validate(article).empty

        where:
        aName | aBudget | aStartDate | anEndDate | aContent | itsPlaces
        "ab" | 0 | new Date(2018, 1, 1) | new Date(2018, 2, 1) | "This travel was amazing ! But the content must have a size of 100 characters so we write some lines ..." | Arrays.asList(Mock(Place), Mock(Place))
        null | 0 | new Date(2018, 1, 1) | new Date(2018, 2, 1) | "This travel was amazing ! But the content must have a size of 100 characters so we write some lines ..." | Arrays.asList(Mock(Place), Mock(Place))
        "abcd" | -1 | new Date(2018, 1, 1) | new Date(2018, 2, 1) | "This travel was amazing ! But the content must have a size of 100 characters so we write some lines ..." | Arrays.asList(Mock(Place))
        "abcd" | 0 | new Date(2018, 1, 1) | new Date(2018, 2, 1) | "This travel was amazing ! But the content must have a size of 100 characters so we write some lines" | Arrays.asList(Mock(Place), Mock(Place))
        "abcd" | 0 | new Date(2018, 1, 1) | new Date(2018, 2, 1) | "This travel was amazing ! But the content must have a size of 100 characters so we write some lines ..." | Arrays.asList()
        "abcd" | 0 | new Date(2018, 1, 1) | new Date(2018, 2, 1) | "This travel was amazing ! But the content must have a size of 100 characters so we write some lines ..." | null
        "abcd" | 0 | new Date(2018, 1, 1) | new Date(2018, 2, 1) | null | Arrays.asList(Mock(Place), Mock(Place))
        "abcd" | 0 | null | new Date(2018, 2, 1) | "This travel was amazing ! But the content must have a size of 100 characters so we write some lines ..." | Arrays.asList(Mock(Place), Mock(Place))
        "abcd" | 0 | new Date(2018, 1, 1) | null | "This travel was amazing ! But the content must have a size of 100 characters so we write some lines ..." | Arrays.asList(Mock(Place), Mock(Place))
    }

    @Unroll
    void "test if the dates of an article are valid"() {

        given: "a start date and a end date"
        Date startDate =  new Date(2018, 2, 1)
        Date endDate =  new Date(2018, 1, 1)

        when : "the article is initialized with those date"
        Article article = new Article(name: "Article", budget : 0, startDate : startDate, endDate : endDate,
                content : "This travel was amazing ! But the content must have a size of 100 characters so we write some lines ...", places : Arrays.asList(Mock(Place)), isVisible : true)

        then: "The article is not valid"
        !validator.validate(article).empty

    }

    @Unroll
    void "test that an article is create with visibility to true by default"() {

        given: "a correctly initialized article without visibility specified"
        Article article = new Article(name: "Article", budget : 0, startDate :  new Date(2018, 1, 1), endDate :  new Date(2018, 2, 1),
                content : "This travel was amazing ! But the content must have a size of 100 characters so we write some lines ...", places : Arrays.asList(Mock(Place)))

        expect: "The article is valid"
        validator.validate(article).empty

        and : "The visibility of the article is true"
        article.getIsVisible() == true

    }

    @Unroll
    void "test that the visibility of an article can be changed"() {

        given: "a correctly initialized article without visibility specified"
        Article article = new Article(name: "Article", budget : 0, startDate :  new Date(2018, 1, 1), endDate :  new Date(2018, 2, 1),
                content : "This travel was amazing ! But the content must have a size of 100 characters so we write some lines ...", places : Arrays.asList(Mock(Place)))

        when: "The visibility is changed"
        article.setIsVisible(false);

        then : "The article is valid"
        validator.validate(article).empty

        and : "The visibility has the new value"
        article.getIsVisible() == false

    }
}
