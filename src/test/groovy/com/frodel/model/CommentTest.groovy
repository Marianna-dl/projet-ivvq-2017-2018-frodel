package com.frodel.model

import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification


/**
 * Created by hichem on 30/03/2018.
 */
import spock.lang.Unroll
import spock.util.mop.Use

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
    void "test if a comment is correct"(String title, Long mark, String content,User commentator) {

        given: "a correctly initialized comment"
        Comment comment = new Comment(title: title,mark:mark,content:content,commentator: commentator)

        expect: "The comment is valid"
        validator.validate(comment).empty

        where:
        title   | mark      | content       |commentator
        ""      | 0         | "my comment"  |new User()
        null    | 0         | "my comment"  |new User()
        "title" | null      | "my comment"  |new User()
    }

    @Unroll
    void "test if a comment is incorrect"(String title, Long mark, String content,User commentator) {

        given: "an incorrectly initialized comment"
        Comment comment = new Comment(title:  title,mark:mark,content:  content, commentator: commentator)

        expect: "The comment is invalid"
        !validator.validate(comment).empty
        where:
        title   | mark | content       | commentator
        ""      | 0    | null          | new User()
        null    | 0    | null          | new User()
        "title" | null | ""            | new User()
        "title" | null | "my comment"  | null
    }
}
