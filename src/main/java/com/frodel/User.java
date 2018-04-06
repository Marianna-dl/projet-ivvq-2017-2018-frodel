
package com.frodel;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by hichem on 30/03/2018.
 */
public class User {
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
}
