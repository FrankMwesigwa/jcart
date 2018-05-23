package com.jcart.modules.security.roles;

import com.jcart.modules.exceptions.JCartException;
import com.jcart.modules.security.permissions.Permission;
import com.jcart.modules.security.permissions.PermissionRepository;
import com.jcart.modules.utilities.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;
import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;

@RestController
public class RoleController {

    private RoleRepository roleRepository;
    private PermissionRepository permissionRepository;
    private RoleService roleService;

    public RoleController(RoleRepository roleRepository , PermissionRepository permissionRepository,
                          RoleService roleService) {
        this.roleRepository = roleRepository;
        this.permissionRepository = permissionRepository;
        this.roleService = roleService;
    }

    @GetMapping("/roles")
    public ResponseEntity<List<RoleDTO>> getAllRoles(Pageable pageable) {
        final Page<RoleDTO> page = roleService.getAllRoles(pageable);
        return new ResponseEntity<>(page.getContent(), HttpStatus.OK);
    }

    @GetMapping("/roles/perms")
    public List<String> getPermissions() {
        return permissionRepository.findAll().stream().map(Permission::getName).collect(Collectors.toList());
    }

    @PostMapping("/roles")
    public ResponseEntity<?> createRole(@Valid @RequestBody Role role) {

        Role roleByName = roleRepository.findByName(role.getName());
        if(roleByName != null){
            throw new JCartException("Role "+role.getName()+" already exists");
        }

        role.setName(role.getName());
        role.setDescription(role.getDescription());

        Set<Permission> persistedPermissions = new HashSet<>();
        Set<Permission> permissions = role.getPermissions();
        if(permissions != null){
            for (Permission permission : permissions) {
                if(permission.getId() != null)
                {
                    persistedPermissions.add(permissionRepository.getOne(permission.getId()));
                }
            }
        }
        role.setPermissions(persistedPermissions);
        Role result = roleRepository.save(role);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/addUser")
                .buildAndExpand(result.getName()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "Role created successfully"));
    }

}
