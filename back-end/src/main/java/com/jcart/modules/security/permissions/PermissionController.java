package com.jcart.modules.security.permissions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class PermissionController {

    private PermissionRepository permRepository;

    public PermissionController(PermissionRepository permRepository) {
        this.permRepository = permRepository;
    }

    @GetMapping("/permissions")
    public List<Permission> getPermissions() {
        return permRepository.findAll();
    }

    @GetMapping("/permissions/{id}")
    public Permission getPermission(@PathVariable long id) {
        Optional<Permission> permission = permRepository.findById(id);
        return permission.get();
    }

    @DeleteMapping("/permissions/{id}")
    public void deletePermission(@PathVariable long id) {
        permRepository.deleteById(id);
    }

    @PostMapping("/permissions")
    public ResponseEntity<Object> createPermission(@RequestBody Permission permission) {
        Permission savedPermission = permRepository.save(permission);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedPermission.getId()).toUri();
        return ResponseEntity.created(location).build();

    }

    @PutMapping("/permissions/{id}")
    public ResponseEntity<Object> updatePermission(@RequestBody Permission permission, @PathVariable long id) {

        Optional<Permission> PermissionOptional = permRepository.findById(id);

        if (!PermissionOptional.isPresent())
            return ResponseEntity.notFound().build();

        permission.setId(id);

        permRepository.save(permission);

        return ResponseEntity.noContent().build();
    }
}
