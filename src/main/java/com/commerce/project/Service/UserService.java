package com.commerce.project.Service;

import com.commerce.project.Entities.User;
import com.commerce.project.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) {
        userRepository.save(user);
    }

    //SERVICE CODES
}
