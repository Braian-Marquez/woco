package com.nocountry.woco.auth.model.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Getter
@Setter
public class AuthenticationRequest {
    private String email;
    private String username=email;
    private String password;
}

