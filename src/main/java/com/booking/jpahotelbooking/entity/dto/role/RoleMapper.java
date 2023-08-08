package com.booking.jpahotelbooking.entity.dto.role;

import com.booking.jpahotelbooking.entity.Roles;
import com.booking.jpahotelbooking.mapper.GenericMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper implements GenericMapper<RoleDTO, Roles> {

    private final ModelMapper modelMapper;

    public RoleMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public RoleDTO convertToDto(Roles entity) {
        return modelMapper.map(entity, RoleDTO.class);
    }
}
