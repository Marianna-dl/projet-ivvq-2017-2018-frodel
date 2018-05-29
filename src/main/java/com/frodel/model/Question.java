package com.frodel.model;

import javax.persistence.*;
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

    @NotNull
    @ManyToOne(cascade = CascadeType.PERSIST)
    private User interrogator;

    public Question (String title, String content)
    {
        this.title = title;
        this.content = content;
    }

    public Question(String title, String content, User interrogator) {
        this.title = title;
        this.content = content;
        this.interrogator = interrogator;
    }
}
