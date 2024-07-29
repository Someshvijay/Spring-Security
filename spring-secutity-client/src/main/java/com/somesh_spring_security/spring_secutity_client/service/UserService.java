package com.somesh_spring_security.spring_secutity_client.service;

import com.somesh_spring_security.spring_secutity_client.entity.User;
import com.somesh_spring_security.spring_secutity_client.model.UserModel;

public interface UserService {
    User registerUser(UserModel userModel);

    void saveVerificationTokenForUser(String token, User user);
}
