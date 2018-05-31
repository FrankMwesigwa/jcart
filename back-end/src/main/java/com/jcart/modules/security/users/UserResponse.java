package com.jcart.modules.security.users;

import lombok.Data;

@Data
public class UserResponse {

    private Long id;
    private String username;
    private String firstName;
    private String lastName;

    public UserResponse(Long id, String username, String firstName, String lastName) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
