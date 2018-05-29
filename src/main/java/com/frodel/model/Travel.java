package com.frodel.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * This class represents one travel
 */
@Entity
public class Travel {

    @NotNull
    @Size(min = 3)
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @OneToOne(mappedBy = "travel", cascade = CascadeType.PERSIST)
    private Article principalArticle;

    @OneToMany(mappedBy = "travel", cascade = CascadeType.PERSIST)
    private List<Article> steps = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.PERSIST)
    private User creator;


    /**
     * Set a name of travel
     * @param name the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Get the name of travel
     * @return the name of travel
     */
    public String getName()
    {
        return this.name;
    }

    public void setPrincipalArticle(Article principalArticle) {
        this.principalArticle = principalArticle;
    }

    public Article getPrincipalArticle() {
        return principalArticle;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }
}
