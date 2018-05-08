package com.frodel

import com.frodel.repositories.UserRepository
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.repository.PagingAndSortingRepository
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

    def "test suppression d'un utilisateur"() {
        when: "une requête de suppression est déclenchée"
        utilisateurController.deleteUser(1)

        then: "l'action est déléguée au repository"
        1 * utilisateurRepository.delete(1)
    }


}
