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

    @OneToMany(cascade = CascadeType.PERSIST)
    private Answer answers;

    public Long getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setInterrogator(User interrogator) {
        this.interrogator = interrogator;
    }

    public void setAnswers(Answer answers) {
        this.answers = answers;
    }
}
