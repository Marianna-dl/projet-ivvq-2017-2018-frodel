package com.frodel.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * This class represents an Answer
 */
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String content;

    @NotNull
    @ManyToOne(cascade = CascadeType.PERSIST)
    private User answerer;

    @NotNull
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Question question;

    public Long getId() {
        return id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAnswerer(User answerer) {
        this.answerer = answerer;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
