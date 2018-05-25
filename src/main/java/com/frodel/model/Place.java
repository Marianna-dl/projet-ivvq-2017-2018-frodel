package com.frodel.model;

import javax.validation.constraints.NotNull;

public class Place {

    @NotNull
    private Continent continent;
    @NotNull
    private Country country;
    @NotNull
    private City city;


}
