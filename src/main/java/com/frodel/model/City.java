package com.frodel.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

class City {

    @NotNull
    @Size(min = 2)
    @Pattern(regexp = "[a-zA-Z]+$")
    private String name;



}
