package com.silver.ws.identityservice.application.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateUserRequestModel {
    @NotNull(message = "First Name cannot be null")
    private String FirstName;

    @NotNull(message = "Last Name cannot be null")
    private String LastName;

    @NotNull(message = "Email cannot be null")
    @Email
    private String Email;

    @NotNull(message = "Password cannot be null")
    @Size(min = 8, message = "Password must be greate than 8 characters")
    private String Password;
}
