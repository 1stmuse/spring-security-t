package com.muse.spring_security.service;


import com.muse.spring_security.entity.User;
import com.muse.spring_security.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public User register(User user) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        return  userRepository.save(user);
    }
}
