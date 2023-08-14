package com.booking.jpahotelbooking.entity.dto.employee;

import com.booking.jpahotelbooking.entity.Employees;
import com.booking.jpahotelbooking.entity.dto.role.RoleDTO;
import com.booking.jpahotelbooking.mapper.GenericMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EmployeesMapper implements GenericMapper<EmployeesDTO, Employees> {

    private final ModelMapper modelMapper;

    public EmployeesMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    // get role from RoleDTO and insert role into EmployeesDTO
    @Override
    public EmployeesDTO convertToDto(Employees entity) {
        EmployeesDTO employeesDTO = modelMapper.map(entity, EmployeesDTO.class);
        employeesDTO.setRoles(modelMapper.map(entity.getRoles(), RoleDTO.class));
        return employeesDTO;
    }

    @Override
    public Employees convertFromDto(EmployeesDTO employeesDTO) {
        return modelMapper.map(employeesDTO, Employees.class);
    }
}