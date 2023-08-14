package com.booking.jpahotelbooking.entity.dto.guest;

import com.booking.jpahotelbooking.entity.Guests;
import com.booking.jpahotelbooking.mapper.GenericMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class GuestMapper implements GenericMapper<GuestDTO, Guests> {

    private final ModelMapper modelMapper;

    public GuestMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public GuestDTO convertToDto(Guests entity) {
        return modelMapper.map(entity, GuestDTO.class);
    }

    @Override
    public Guests convertFromDto(GuestDTO guestDTO) {
        return modelMapper.map(guestDTO, Guests.class);
    }
}
