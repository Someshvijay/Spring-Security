package com.somesh_spring_security.spring_secutity_client.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {


    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String matchingPassword;

}
