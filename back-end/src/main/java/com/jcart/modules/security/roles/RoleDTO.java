package com.jcart.modules.security.roles;

import com.jcart.modules.security.permissions.Permission;
import lombok.Data;

import java.util.Set;
import java.util.stream.Collectors;

@Data
public class RoleDTO {
    private Long id;
    private String name;
    private String description;
    private Set<Long> permId;
    private Set<String> permissions;

    public RoleDTO(){}

    public RoleDTO(Role role) {
        this(

                role.getId(),
                role.getName(),
                role.getDescription(),
                role.getPermissions().stream().map(Permission::getName).collect(Collectors.toSet())
        );
    }

    public RoleDTO(Long id, String name, String description , Set<String> permissions) {

        this.id = id;
        this.name = name;
        this.description = description;
        this.permissions = permissions;
    }
}
