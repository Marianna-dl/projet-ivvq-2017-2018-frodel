package com.frodel.services;

import com.frodel.model.User;
import com.frodel.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hichem on 30/03/2018.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository ;

    /**
     * Save the given utilisateur
     * @param utilisateur the utilisateur
     * @return the saved utilisateur
     */
    public User saveUser(User utilisateur) {
        return userRepository.save(utilisateur) ;
    }

    /**
     * get user by Pseudo
     * @param pseudo the pseudo of the user
     * @return the user
     */
    public User findUserByPseudo(String pseudo) {
        return userRepository.findUserByPSeudo(pseudo) ;
    }

    public User findOneUser(Long id) {
        return userRepository.findOne(id);
    }
}
