package com.nocountry.woco.auth.controller;

import com.nocountry.woco.auth.model.request.AuthenticationRequest;
import com.nocountry.woco.auth.model.request.UserRequest;
import com.nocountry.woco.auth.model.response.AuthenticationResponse;
import com.nocountry.woco.auth.model.response.UserResponse;
import com.nocountry.woco.auth.service.UserDetailsCustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.io.IOException;

@CrossOrigin(origins = "**")
@RestController
@RequestMapping("/auth")
public class UserAuthController {

    @Autowired
    private UserDetailsCustomService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> signup(@Valid @RequestBody UserRequest user) throws IOException {
        UserResponse result = this.userDetailsService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);

    }
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login (
            @RequestBody @Valid AuthenticationRequest authenticationRequest)  {
        return ResponseEntity.ok(userDetailsService.login(authenticationRequest));
    }

}
