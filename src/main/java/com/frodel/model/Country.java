package com.frodel.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class Country {

    @NotNull
    @Size(min = 4)
    @Pattern(regexp = "[a-zA-Z]+$")
    private String name;

    @NotNull
    @Size(min = 1)
    private List<City> cities;
}
