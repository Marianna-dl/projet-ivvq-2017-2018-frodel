package com.frodel.model

import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification


/**
 * Created by hichem on 30/03/2018.
 */
import spock.lang.Unroll

import javax.validation.Validation
import javax.validation.Validator
import javax.validation.ValidatorFactory

@SpringBootTest
class CommentTest extends Specification {

    Validator validator

    void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Unroll
    void "test if a comment is correct"(String title, Long mark, String content) {

        given: "a correctly initialized comment"
        Comment comment = new Comment(title,mark,content)

        expect: "The comment is valid"
        validator.validate(comment).empty

        where:
        title   | mark       | content
        "" | 0  | "my comment"
        null | 0  | "my comment"
        "title" | null | "my comment"
    }

    @Unroll
    void "test if a comment is incorrect"(String title, Long mark, String content) {

        given: "an incorrectly initialized comment"
        Comment comment = new Comment(title,mark,content)

        expect: "The comment is invalid"
        !validator.validate(comment).empty

        where:
        where:
        title   | mark       | content
        "" | 0  | null
        null | 0  | null
        "title" | null | ""
    }
}
