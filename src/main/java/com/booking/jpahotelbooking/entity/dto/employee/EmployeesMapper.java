package com.booking.jpahotelbooking.entity.dto.employee;

import com.booking.jpahotelbooking.entity.Employees;
import com.booking.jpahotelbooking.mapper.GenericMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EmployeesMapper implements GenericMapper<EmployeeRequestDTO, EmployeeResponseDTO, Employees> {

    private final ModelMapper modelMapper;

    public EmployeesMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public EmployeeResponseDTO convertToDto(Employees entity) {
        return modelMapper.map(entity, EmployeeResponseDTO.class);
    }

    @Override
    public Employees convertToEntity(EmployeeRequestDTO employeeRequestDTO) {
        return modelMapper.map(employeeRequestDTO, Employees.class);
    }
}