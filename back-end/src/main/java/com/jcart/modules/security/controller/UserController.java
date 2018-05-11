package com.jcart.modules.security.controller;

import com.jcart.modules.security.entities.User;
import com.jcart.modules.security.repository.UserRepository;
import com.jcart.modules.utities.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;
    //private RoleRepository roleRepository;

    public UserController(UserRepository userRepository , BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        //this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@Valid @RequestBody User user) {
        if(userRepository.existsByUsername(user.getUsername())) {
            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existsByEmail(user.getEmail())) {
            return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"),
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        //Set<Role> roleList = new HashSet<>();
        User users = new User();

        users.setUsername(user.getUsername());
        users.setPassword(passwordEncoder.encode(user.getPassword()));
        users.setFirstname(user.getFirstname());
        users.setLastname(user.getLastname());
        users.setEmail(user.getEmail());

        User result = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/addUser")
                .buildAndExpand(result.getUsername()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "User added successfully"));
    }
}
