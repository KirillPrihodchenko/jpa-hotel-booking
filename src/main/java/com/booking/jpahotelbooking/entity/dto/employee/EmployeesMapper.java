package com.booking.jpahotelbooking.entity.dto;

import com.booking.jpahotelbooking.entity.Employees;
import com.booking.jpahotelbooking.mapper.GenericMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EmployeesMapper implements GenericMapper<EmployeesDTO, Employees> {

    private final ModelMapper modelMapper;

    public EmployeesMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public EmployeesDTO convertToDto(Employees entity) {
        return modelMapper.map(entity, EmployeesDTO.class);
    }
}