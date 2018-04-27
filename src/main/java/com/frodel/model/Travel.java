package com.frodel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

    /**
     * Set a name of travel
     * @param name the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }


}
