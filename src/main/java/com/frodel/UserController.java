package com.frodel;

import com.frodel.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by hichem on 08/05/2018.
 */
@RestController
public class UserController {
    @Autowired
    private UserRepository utilisateurRepository;

    @RequestMapping(value = "/inscriptions", method = RequestMethod.POST)
    public User addUser(@RequestParam(value = "pseudo") String pseudo, @RequestParam(value = "mdp") String mdp,@RequestParam(value = "email") String email) {
        User utilisateur = new User(pseudo,mdp,email);
        utilisateurRepository.save(utilisateur);
        return utilisateur;
    }

    @RequestMapping(value = "/inscriptions/{user_id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("user_id") Long userId) {
        utilisateurRepository.delete(userId);
    }
}
