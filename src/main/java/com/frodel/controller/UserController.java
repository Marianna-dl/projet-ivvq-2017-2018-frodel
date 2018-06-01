package com.frodel.controller;

import com.frodel.model.User;
import com.frodel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by hichem on 08/05/2018.
 */
@RestController
@CrossOrigin
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
     * @api {get} /user/userPseudo/{userPseudo}
     * @apiSampleRequest /user/userPseudo/toto
     * @apiParamExample {json} Request-Example:
     *     {
     *       "userPseudo" : [{"toto"}, {"titi"}]
     *     }
     * @apiName findUserByPseudo
     * @apiGroup User
     * @apiDescription find user with a given pseudo
     *
     * @apiParam {String} userPseudo The pseudo of searched user
     * @apiSuccess {User} User the user
     */
    @RequestMapping("/user/userPseudo/{userPseudo}")
    public User findUserByPseudo(@PathVariable  String userPseudo) {
        return userService.findUserByPseudo(userPseudo);
    }


    /**
     * @api {get} /users/
     * @apiSampleRequest /users/
     * @apiName findAllUsers
     * @apiGroup User
     * @apiDescription find all users
     *
     *
     * @apiSuccess {User[]} User the list of users
     */
    @RequestMapping("/users")
    public Iterable<User> findAllUsers() {
        return userService.findAllUsers();
    }

}
