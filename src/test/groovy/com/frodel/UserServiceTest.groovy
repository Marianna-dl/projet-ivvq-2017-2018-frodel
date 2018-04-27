package com.frodel

import com.frodel.repositories.UserRepository
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.repository.PagingAndSortingRepository
import spock.lang.Specification


/**
 * Created by hichem on 30/03/2018.
 */
import spock.lang.Unroll

import javax.validation.Validation
import javax.validation.Validator
import javax.validation.ValidatorFactory

@SpringBootTest
class UserServiceTest extends Specification {

    UserService utilisateurService
    UserRepository utilisateurRepository

    void setup() {
        utilisateurRepository = Mock()
        utilisateurService = new UserService()
        utilisateurService.utilisateurRepository = utilisateurRepository
    }

    def "vérifier  le type d'un utilisateurRepository"() {
        expect: "utilisateurRepository est un Spring repository"
        utilisateurRepository instanceof PagingAndSortingRepository
    }

    def "tester la delegation de la sauvegarde d'un Utilisateur à repository"() {
        given: "un utilisateur"
        def utilisateur = Mock(User)

        when: "l'utilisateur est enregistré"
        utilisateurService.saveUser(utilisateur);

        then: "la sauvegarde est deléguée à utilisateurRepository"
        1 * utilisateurRepository.save(utilisateur)
    }


}
