package com.jcart.modules.security.roles;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import javax.transaction.Transactional;

@Service
@Transactional
public class RoleService {

    private RoleRepository roleRepository;
    private RoleDTO roleDTO;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
        this.roleDTO = roleDTO;
    }

    public Page<RoleDTO> getAllRoles(Pageable pageable) {
        return roleRepository.findAll(pageable).map(RoleDTO::new);
    }
}
