package com.jcart.modules.security.controller;

import com.jcart.modules.exceptions.JCartException;
import com.jcart.modules.security.entities.Permission;
import com.jcart.modules.security.entities.Role;
import com.jcart.modules.security.entities.RoleDTO;
import com.jcart.modules.security.repository.PermissionRepository;
import com.jcart.modules.security.repository.RoleRepository;
import com.jcart.modules.utilities.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.*;

@RestController
public class RoleController {

    private RoleRepository roleRepository;
    private PermissionRepository permissionRepository;

    public RoleController(RoleRepository roleRepository , PermissionRepository permissionRepository) {
        this.roleRepository = roleRepository;
        this.permissionRepository = permissionRepository;
    }


    @GetMapping("/roles")
    public List<Role> rolesList(){
        return roleRepository.findAll();
    }

    @PostMapping("/roles")
    public ResponseEntity<?> createRole(@Valid @RequestBody RoleDTO roleDTO) {

        Role roleByName = roleRepository.findByName(roleDTO.getName());
        if(roleByName != null){
            throw new JCartException("Role "+roleDTO.getName()+" already exists");
        }

        Set<Permission> PermissionList = new HashSet<>();
        Role role = new Role();

        role.setName(roleDTO.getName());
        role.setDescription(roleDTO.getDescription());

        if (roleDTO.getPermissions() != null) {
            for (Long permId : roleDTO.getPermissions()) {
                Permission perm = permissionRepository.getOne(permId);
                PermissionList.add(perm);
            }
            role.setPermissions(PermissionList);
        }

        Role result = roleRepository.save(role);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/addUser")
                .buildAndExpand(result.getName()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "Role created successfully"));
    }

}
