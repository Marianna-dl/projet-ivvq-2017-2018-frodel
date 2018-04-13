package com.frodel.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * This class represents one travel
 */
public class Travel {

    @NotNull
    @Size(min = 3)
    private String name;

    /**
     * Set a name of travel
     * @param name the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }
}
