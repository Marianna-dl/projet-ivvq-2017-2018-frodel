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
    private Continent continent;
    @NotNull
    @OneToOne
    private Country country;
    @NotNull
    @OneToOne
    private City city;


}
