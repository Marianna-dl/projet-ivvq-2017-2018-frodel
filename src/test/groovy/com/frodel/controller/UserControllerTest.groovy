package com.frodel.controller

import com.frodel.controller.UserController
import com.frodel.repositories.UserRepository
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

/**
 * Created by hichem on 30/03/2018.
 */
@SpringBootTest
class UserControllerTest extends Specification {

    UserRepository utilisateurRepository
    UserController utilisateurController
    void setup() {
        utilisateurRepository = Mock()
        utilisateurController = new UserController(
                utilisateurRepository: utilisateurRepository
        )
    }

    def "test ajout d'un utilisateur "() {
        when: "une requête d'ajout est déclenchée"
        utilisateurController.addUser("frodel","frodeltest","frodel@frodel.fr")

        then: "différentes actions sur les différents repository sont déclenchées"
        1 * utilisateurRepository.save(_)
    }



}
