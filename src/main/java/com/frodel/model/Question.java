package com.frodel.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * This class represents a question
 */
@Entity
public class Question {
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
