package com.booking.jpahotelbooking.entity.dto.guest;

import com.booking.jpahotelbooking.entity.Guests;
import com.booking.jpahotelbooking.mapper.GenericMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class GuestMapper implements GenericMapper<GuestRequestDTO, GuestResponseDTO, Guests> {

    private final ModelMapper modelMapper;

    public GuestMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public Guests convertToEntity(GuestRequestDTO guestRequestDTO) {
        return modelMapper.map(guestRequestDTO, Guests.class);
    }

    @Override
    public GuestResponseDTO convertToDto(Guests guests) {
        return modelMapper.map(guests, GuestResponseDTO.class);
    }
}
