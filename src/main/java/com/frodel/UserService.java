package com.frodel;

import com.frodel.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hichem on 30/03/2018.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository utilisateurRepository ;

    /**
     * Save the given utilisateur
     * @param utilisateur the utilisateur
     * @return the saved utilisateur
     */
    public User saveUser(User utilisateur) {
        return utilisateurRepository.save(utilisateur) ;
    }
}
