package com.frodel.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Continent {

    @NotNull
    @Size(min = 3)
    @Pattern(regexp = "[a-zA-Z ]+$")
    private String name;

    @NotNull
    @Size(min = 1)
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Country> countries;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Get the name of the continent
     *
     * @return The name of the continent
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of continent
     *
     * @param name The name of the continent to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get countries of the continent
     *
     * @return Countries of the continent
     */
    public List<Country> getCountries() {
        return countries;
    }

    /**
     * Set countries of continent
     *
     * @param countries Countries of continent to set
     */
    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }
}
