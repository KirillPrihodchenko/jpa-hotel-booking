package com.booking.jpahotelbooking.entity.dto.guest;

import com.booking.jpahotelbooking.entity.Guest;
import com.booking.jpahotelbooking.mapper.GenericMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class GuestMapper implements GenericMapper<GuestRequestDTO, GuestResponseDTO, Guest> {

    private final ModelMapper modelMapper;

    public GuestMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public Guest convertToEntity(GuestRequestDTO guestRequestDTO) {
        return modelMapper.map(guestRequestDTO, Guest.class);
    }

    @Override
    public GuestResponseDTO convertToDto(Guest guests) {
        return modelMapper.map(guests, GuestResponseDTO.class);
    }
}
