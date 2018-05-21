package com.jcart.modules.security.users;

import com.jcart.modules.exceptions.JCartException;
import com.jcart.modules.security.roles.Role;
import com.jcart.modules.security.roles.RoleRepository;
import com.jcart.modules.utilities.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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

    @PostMapping("/users")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDTO userDTO) {

        User userByEmail = userRepository.findByEmail(userDTO.getEmail());
        if(userByEmail != null){
            throw new JCartException("Email "+userDTO.getEmail()+" already in use");
        }

        Set<Role> roleList = new HashSet<>();
        User user = new User();

        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setFirstname(userDTO.getFirstname());
        user.setLastname(userDTO.getLastname());
        user.setEmail(userDTO.getEmail());

        if (userDTO.getRoles() != null) {
            for (Long roleId : userDTO.getRoles()) {
                Role role = roleRepository.getOne(roleId);
                roleList.add(role);
            }
            user.setRoles(roleList);
        }

        User result = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/addUser")
                .buildAndExpand(result.getUsername()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "User created successfully"));
    }
}
