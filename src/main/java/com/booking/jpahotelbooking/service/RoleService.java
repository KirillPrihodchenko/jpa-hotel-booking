package com.booking.jpahotelbooking.service;

import com.booking.jpahotelbooking.entity.Roles;
import com.booking.jpahotelbooking.entity.dto.role.RoleDTO;
import com.booking.jpahotelbooking.entity.dto.role.RoleMapper;
import com.booking.jpahotelbooking.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public RoleService(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    public Roles createRole(RoleDTO roleDTO) {
        Roles roles = roleMapper.convertToEntity(roleDTO);
        return roleRepository.save(roles);
    }
}
