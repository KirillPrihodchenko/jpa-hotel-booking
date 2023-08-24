package com.booking.jpahotelbooking.entity.dto.employee;

import com.booking.jpahotelbooking.entity.Employee;
import com.booking.jpahotelbooking.mapper.GenericMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper implements GenericMapper<EmployeeRequestDTO, EmployeeResponseDTO, Employee> {

    private final ModelMapper modelMapper;

    public EmployeeMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public EmployeeResponseDTO convertToDto(Employee entity) {
        return modelMapper.map(entity, EmployeeResponseDTO.class);
    }

    @Override
    public Employee convertToEntity(EmployeeRequestDTO employeeRequestDTO) {
        return modelMapper.map(employeeRequestDTO, Employee.class);
    }
}