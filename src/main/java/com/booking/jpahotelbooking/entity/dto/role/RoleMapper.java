package com.booking.jpahotelbooking.entity.dto.role;

import com.booking.jpahotelbooking.entity.Role;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {

    private final ModelMapper modelMapper;

    public RoleMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public RoleDTO convertToDto(Role entity) {
        return modelMapper.map(entity, RoleDTO.class);
    }

    public Role convertToEntity(RoleDTO roleDTO) {
        return modelMapper.map(roleDTO, Role.class);
    }
}