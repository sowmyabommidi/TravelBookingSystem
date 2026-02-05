package com.travel.service;

import com.travel.entity.User;
import com.travel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // ✅ REGISTER
    public User register(User user) {
        return userRepository.save(user);
    }

    // ✅ LOGIN: email + password authentication
    public User authenticate(String email, String password) {

        List<User> users = userRepository.findByEmailAndPassword(email, password);

        // ✅ if at least one match exists, login success
        if (!users.isEmpty()) {
            return users.get(0);
        }

        return null; // ❌ invalid credentials
    }
}
