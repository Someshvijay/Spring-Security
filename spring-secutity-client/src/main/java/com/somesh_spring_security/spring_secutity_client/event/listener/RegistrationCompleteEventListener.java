package com.somesh_spring_security.spring_secutity_client.event.listener;

import com.somesh_spring_security.spring_secutity_client.entity.User;
import com.somesh_spring_security.spring_secutity_client.event.RegistrationCompleteEvent;
import com.somesh_spring_security.spring_secutity_client.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;

import java.util.UUID;

@Slf4j
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        //create verification token for the user with the link
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token,user);

        //Send Mail to user
        String url = event.getApplicationUrl() + "verifyRegistration?token=" + token ;

        log.info("Click the link to verify your account: {}", url);
    }
}
