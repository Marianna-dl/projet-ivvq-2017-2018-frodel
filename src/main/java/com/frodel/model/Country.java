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


}
