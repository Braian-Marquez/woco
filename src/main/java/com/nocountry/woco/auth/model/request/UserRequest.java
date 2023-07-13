package com.nocountry.woco.auth.model.request;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Getter
@Setter
public class UserRequest {
    @NotBlank(message = "First name can not be empty")
    private String firstName;

    @NotBlank(message = "Last name can not be empty")
    private String lastName;

    @NotBlank(message = "Email can not be empty")
    @Email(message = "Email is not valid")
    private String email;
    
    @Size(min = 8)
    private String password;

    private String token;

}
