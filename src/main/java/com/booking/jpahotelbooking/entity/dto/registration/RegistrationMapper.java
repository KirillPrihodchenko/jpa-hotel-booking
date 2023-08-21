package com.booking.jpahotelbooking.entity.dto.registration;

import com.booking.jpahotelbooking.entity.Registration;
import com.booking.jpahotelbooking.mapper.GenericMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RegistrationMapper implements GenericMapper<RegistrationRequestDTO, RegistrationResponseDTO, Registration> {

    private final ModelMapper modelMapper;

    public RegistrationMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public RegistrationResponseDTO convertToDto(Registration entity) {
        return modelMapper.map(entity, RegistrationResponseDTO.class);
    }

    @Override
    public Registration convertToEntity(RegistrationRequestDTO registrationRequestDTO) {
        return modelMapper.map(registrationRequestDTO, Registration.class);
    }
}
