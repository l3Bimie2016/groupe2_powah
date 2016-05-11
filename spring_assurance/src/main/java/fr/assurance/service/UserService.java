package fr.assurance.service;

import fr.assurance.dao.UserRepository;
import fr.assurance.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Max on 11/05/2016.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;


    public User findByName(String username) {
        return userRepo.findByName(username);
    }
}
