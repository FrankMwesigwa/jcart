package com.jcart.modules.security.entities;

import lombok.Data;

import java.util.Set;

@Data
public class UserDTO {

    private String username;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private Set<Long> roles;

}
