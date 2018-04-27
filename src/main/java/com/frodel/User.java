
package com.frodel;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by hichem on 30/03/2018.
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    private String pseudo;
    @NotNull
    @NotEmpty
    @Size (min=8)
    private String mdp;
    @NotNull
    @NotEmpty
    @Email
    private String email;
    User(String pseudo, String mdp, String email) {
        this.pseudo = pseudo;
        this.mdp = mdp;
        this.email =email;
    }

    public Long getId() {
        return id;
    }
}
