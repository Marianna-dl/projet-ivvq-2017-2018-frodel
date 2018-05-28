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
    @OneToOne(cascade = CascadeType.PERSIST)
    private Article principalArticle;

    private List<Article> steps = new ArrayList<>();

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
}
