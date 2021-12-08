package com.silver.app.ws.ui.models.request;

import javax.validation.constraints.NotNull;

public class UserRequest {
    @NotNull(message = "FirstName cannot be null")
    private String FirstName;
    @NotNull
    private String LastName;
    @NotNull
    private String Email;
    @NotNull
    private String UserId;

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

}
