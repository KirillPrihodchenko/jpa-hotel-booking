package com.booking.jpahotelbooking.entity.dto.hotel;

import com.booking.jpahotelbooking.entity.Hotel;
import com.booking.jpahotelbooking.mapper.GenericMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class HotelMapper implements GenericMapper<HotelDTO, Hotel> {

    private final ModelMapper modelMapper;

    public HotelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public HotelDTO convertToDto(Hotel entity) {
        return modelMapper.map(entity, HotelDTO.class);
    }

    @Override
    public Hotel convertFromDto(HotelDTO hotelDTO) {
        return modelMapper.map(hotelDTO, Hotel.class);
    }
}
