package com.frodel.services

import com.frodel.model.User
import com.frodel.repositories.UserRepository
import com.frodel.services.UserService
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.repository.PagingAndSortingRepository
import spock.lang.Specification


/**
 * Created by hichem on 30/03/2018.
 */
@SpringBootTest
class UserServiceTest extends Specification {

    UserService userService
    UserRepository userRepository

    void setup() {
        userRepository = Mock()
        userService = new UserService()
        userService.utilisateurRepository = userRepository
    }

    def "check type of commentRepository"() {
        expect: "userRepository is a Spring repository"
        userRepository instanceof PagingAndSortingRepository
    }

    def "test delegation of save of an user to the repository"() {
        given: "a user"
        def utilisateur = Mock(User)

        when: "the user is saved"
        userService.saveUser(utilisateur);

        then: "the save is delegated to the userRepository"
        1 * userRepository.save(utilisateur)
    }

    def "test delegation of find one user to the repository"() {
        given: "a user"
        def utilisateur = Mock(User)

        when: "the user is found"
        userService.findOneUser(utilisateur.id);

        then: "the find is delegated to the userRepository"
        1 * userRepository.findOne(utilisateur.id)
    }

}
