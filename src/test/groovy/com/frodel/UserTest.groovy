package com.frodel

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration

/**
 * Created by hichem on 30/03/2018.
 */

import spock.lang.Specification
import spock.lang.Unroll
import com.frodel.User

@SpringBootTest
class UserTest extends Specification {

    /*@Autowired UserService userService*/

    def  "create user"(){

        when: "the utilisateur is created"
        User frodel = new User("frodel", "frodel", "frodel@frodel.com")

        then: "the utilisateur is not null"
        frodel != null


    }

   /* def "save user"(){
        given: "a valid utilisateur"
        User bob = new User("frodel", "frodelmdp", "frodel@frodel.fr")

        when: "the utilisateur is saved"
        userService.saveUtilisateur(bob);

        then: "the utilisateur has an id"
        bob.id != null
    }*/
}
