package com.frodel.controller

import com.frodel.repositories.UserRepository
import com.frodel.services.UserService
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

/**
 * Created by hichem on 30/03/2018.
 */
@SpringBootTest
class UserControllerTest extends Specification {

    UserRepository userRepository
    UserController userController
    UserService userService
    void setup() {
        userService = Mock()
        userRepository = Mock()
        userController = new UserController(
                userService: userService
        )
    }

    def "add a user by calling controller "() {
        when: "adding a user"
        userController.addUser("frodel","frodeltest","frodel@frodel.fr")

        then: "the request is performed"
        1 * userService.saveUser(_)
    }

    def "test to find a user with a given pseudo by calling controller"() {

        when: "requesting for a user with the given pseudo"
        userController.findUserByPseudo("frodel")

        then: "the request is performed"
        1 * userService.findUserByPseudo("frodel")
    }


}
