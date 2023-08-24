package com.booking.jpahotelbooking.service;

import com.booking.jpahotelbooking.entity.Role;
import com.booking.jpahotelbooking.entity.dto.role.RoleDTO;
import com.booking.jpahotelbooking.entity.dto.role.RoleMapper;
import com.booking.jpahotelbooking.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor

@Service
public class RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public Role createRole(RoleDTO roleDTO) {
        Role roles = roleMapper.convertToEntity(roleDTO);
        return roleRepository.save(roles);
    }
}
