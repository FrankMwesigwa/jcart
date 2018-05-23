package com.jcart.modules.security.users;

import lombok.Data;

import java.util.Set;

@Data
public class UserDTO {

    private Long branchId;
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Set<Long> roles;

}
