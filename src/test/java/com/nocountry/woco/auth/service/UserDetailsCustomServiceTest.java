package com.nocountry.woco.auth.service;

import com.nocountry.woco.auth.model.request.UserRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserDetailsCustomServiceTest {
@Autowired
private UserDetailsCustomService userDetailsCustomService;
    @Test
    void save() throws IOException {
        /*UserRequest request = new UserRequest();
        request.setFirstName("Erik");
        request.setEmail("");
        request.setPassword("123456789");
        System.out.println(userDetailsCustomService.save(request));*/
    }
}