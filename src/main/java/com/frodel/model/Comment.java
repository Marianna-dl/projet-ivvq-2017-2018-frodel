package com.frodel.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
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
    private String title;
    private Long mark;
    @NotNull
    @NotEmpty
    private String content;

    @NotNull
    @ManyToOne
    private User commentator;

    @NotNull
    @ManyToOne
    private Article article;

    public Comment(){}
    public Comment(String title,Long mark,String content,User commentator, Article article){
        this.title = title;
        this.mark = mark;
        this.content = content;
        this.commentator = commentator;
        this.article = article;

    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Long getMark() {
        return mark;
    }

    public String getContent() {
        return content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMark(Long mark) {
        this.mark = mark;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getCommentator() {return commentator;}

    public Article getArticle() {return article;}

    public void setCommentator(User commentator) {this.commentator = commentator;}

    public void setArticle(Article article) {this.article = article;}
}
