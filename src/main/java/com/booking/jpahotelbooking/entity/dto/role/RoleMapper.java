package com.booking.jpahotelbooking.entity.dto.role;

import com.booking.jpahotelbooking.entity.Roles;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {

    private final ModelMapper modelMapper;

    public RoleMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public RoleDTO convertToDto(Roles entity) {
        return modelMapper.map(entity, RoleDTO.class);
    }

    public Roles convertToEntity(RoleDTO roleDTO) {
        return modelMapper.map(roleDTO, Roles.class);
    }
}