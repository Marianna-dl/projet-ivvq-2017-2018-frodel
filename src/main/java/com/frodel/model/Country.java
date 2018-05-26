package com.frodel.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Country {

    @NotNull
    @Size(min = 4)
    @Pattern(regexp = "[a-zA-Z]+$")
    private String name;

    @NotNull
    @Size(min = 1)
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<City> cities;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Get the name of the country
     *
     * @return The name of the country
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of country
     *
     * @param name The name of county to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get cities of a country
     *
     * @return Cities of country
     */
    public List<City> getCities() {
        return cities;
    }

    /**
     * Set cities of country
     *
     * @param cities Cities of country to set
     */
    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
