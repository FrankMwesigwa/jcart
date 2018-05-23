package com.jcart.modules.security.users;

import com.jcart.modules.security.roles.RoleRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;



import java.util.*;

@RestController
public class UserController {

    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public UserController(PasswordEncoder passwordEncoder, UserRepository userRepository,
                          RoleRepository roleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @GetMapping("/users")
    public List<User> listUsers(){
        return userRepository.findAll();
    }


}
