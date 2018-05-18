package com.frodel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * This class represents a question
 */
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @NotNull
    @Pattern(regexp = ".*\\?$")
    private String content;

    public Question (String title, String content)
    {
        this.title = title;
        this.content = content;
    }
}
