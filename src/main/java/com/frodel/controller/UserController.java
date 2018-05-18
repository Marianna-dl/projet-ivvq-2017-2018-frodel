package com.frodel.controller;

import com.frodel.model.User;
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

    /**
     * @api {post} /inscriptions/
     * @apiName addUser
     * @apiGroup User
     * @apiDescription Add an user
     *
     * @apiParam {String} pseudo The pseudo of new user
     * @apiParam {String} mdp The password of new user
     * @apiParam {String} email The email of new user
     *
     * @apiSuccess {User} utilisateur The new user
     **/
    @RequestMapping(value = "/inscriptions", method = RequestMethod.POST)
    public User addUser(@RequestParam(value = "pseudo") String pseudo, @RequestParam(value = "mdp") String mdp, @RequestParam(value = "email") String email) {
        User utilisateur = new User(pseudo,mdp,email);
        utilisateurRepository.save(utilisateur);
        return utilisateur;
    }

    /**
     * @api {delete} /inscriptions/:userId
     * @apiName deleteUser
     * @apiGroup User
     * @apiDescription Delete an user
     *
     * @apiParam {Long} userId The id of user to delete
     *
     **/
    @RequestMapping(value = "/inscriptions/{user_id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("user_id") Long userId) {
        utilisateurRepository.delete(userId);
    }
}
