package com.frodel.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by hichem on 18/05/2018.
 */
@Entity
public class Comment {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(min = 0)
    private String title;
    @Min(0)
    @Max(5)
    private Long mark;
    @NotNull
    @NotEmpty
    private String content;

    @NotNull
    @ManyToOne(cascade = CascadeType.PERSIST)
    private User commentator;

    public Long getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMark(Long mark) {
        this.mark = mark;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setCommentator(User commentator) {this.commentator = commentator;}


}
