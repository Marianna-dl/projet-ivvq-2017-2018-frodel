package com.frodel.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Place {

    @NotNull
    @OneToOne
    private Continent continent;

    @NotNull
    @OneToOne
    private Country country;

    @NotNull
    @OneToOne
    private City city;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
