package com.jcart.modules.security.entities;

import lombok.Data;

import java.util.Set;

@Data
public class RoleDTO {
    private String name;
    private String description;
    private Set<Long> permissions;
}
