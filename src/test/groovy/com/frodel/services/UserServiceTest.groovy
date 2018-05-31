package com.frodel.services

import com.frodel.model.User
import com.frodel.repositories.UserRepository
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
        userService.userRepository = userRepository
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
        def user = Mock(User)

        when: "the user is found"
        userService.findOneUser(user.id);

        then: "the find is delegated to the userRepository"
        1 * userRepository.findOne(user.id)
    }

    def "test delegation of find user by pseudo to the repository"() {
        given: "a user"
        def user = Mock(User)

        when: "the user is found"
        userService.findUserByPseudo(user.pseudo);

        then: "the find is delegated to the userRepository"
        1 * userRepository.findUserByPSeudo(user.pseudo)
    }

    def "test delegation of finding all users to the repository"() {
        when: "requesting for all users"
        userService.findAllUsers()

        then: "the request is delegated to the userRepository"
        1 * userRepository.findAll()
    }

}
