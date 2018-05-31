package com.frodel.controller;

import com.frodel.model.User;
import com.frodel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by hichem on 08/05/2018.
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

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
     * @apiSuccess {User} User The new user
     **/
    @RequestMapping(value = "/inscriptions", method = RequestMethod.POST)
    public User addUser(@RequestParam(value = "pseudo") String pseudo, @RequestParam(value = "mdp") String mdp, @RequestParam(value = "email") String email) {
        User user = new User(pseudo,mdp,email);
        userService.saveUser(user);
        return user;
    }


    /**
     * @api {get} /user/pseudo/:userPseudo
     * @apiName findUserByPseudo
     * @apiGroup User
     * @apiDescription find user with a given pseudo
     *
     * @apiParam {String} userPseudo The pseudo of searched user
     * @apiSuccess {User} the user
     */
    @RequestMapping("/user/pseudo/{pseudo}")
    public User findUserByPseudo(@PathVariable  String userPseudo) {
        return userService.findUserByPseudo(userPseudo);
    }

}
