package com.frodel.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * This class represents a question
 */
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(min = 0)
    private String title;
    @NotNull
    @Pattern(regexp = ".*\\?$")
    private String content;

    @NotNull
    @ManyToOne(cascade = CascadeType.PERSIST)
    private User interrogator;

    @OneToMany(mappedBy = "question") @JsonIgnore
    private List<Answer> answers;

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

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
