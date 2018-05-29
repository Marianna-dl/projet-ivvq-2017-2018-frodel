package com.frodel.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @OneToOne
    @OneToMany(cascade = { CascadeType.REMOVE})
    private Continent continent;

    @NotNull
    @OneToOne
    private Country country;

    @NotNull
    @OneToOne
    private City city;


    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
