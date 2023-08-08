package com.booking.jpahotelbooking.entity.dto.hotel;

import com.booking.jpahotelbooking.entity.HotelLocation;
import com.booking.jpahotelbooking.mapper.GenericMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class HotelLocationMapper implements GenericMapper<HotelLocationDTO, HotelLocation> {

    private final ModelMapper modelMapper;

    public HotelLocationMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public HotelLocationDTO convertToDto(HotelLocation entity) {
        return modelMapper.map(entity, HotelLocationDTO.class);
    }
}
