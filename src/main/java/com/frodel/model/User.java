
package com.frodel.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "commentator") @JsonIgnore
    private List<Comment> comments;

    @OneToMany(mappedBy = "creator") @JsonIgnore
    private List<Travel> travels = new ArrayList<>();

    public User()
    {}

    public User(String pseudo, String mdp, String email) {
        this.pseudo = pseudo;
        this.mdp = mdp;
        this.email = email;
    }

    public Long getId() {
        return this.id;
    }
    public String getPseudo() {return this.pseudo;}
    public String getEmail() {return this.email;}
    public String getMdp() {return this.mdp;}

    public void setPseudo(String pseudo) {this.pseudo = pseudo;}
    public void setEmail(String email) {this.email = email;}
    public void setMdp(String mdp) {this.mdp = mdp;}

    public List<Travel> getTravels() {
        return travels;
    }
}
