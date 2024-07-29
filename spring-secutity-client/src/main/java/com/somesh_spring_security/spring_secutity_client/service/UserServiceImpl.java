package com.somesh_spring_security.spring_secutity_client.service;

import com.somesh_spring_security.spring_secutity_client.entity.User;
import com.somesh_spring_security.spring_secutity_client.entity.VerificationToken;
import com.somesh_spring_security.spring_secutity_client.model.UserModel;
import com.somesh_spring_security.spring_secutity_client.repository.UserRepository;
import com.somesh_spring_security.spring_secutity_client.repository.VerificationTokenrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VerificationTokenrepository verificationTokenrepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(UserModel userModel) {
        User user = new User();
        user.setEmail(userModel.getEmail());
        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        user.setRole("USER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);
        return user;
    }

    @Override
    public void saveVerificationTokenForUser(String token, User user) {
        VerificationToken verificationToken = new VerificationToken(user, token);
        verificationTokenrepository.save(verificationToken);
    }
}
