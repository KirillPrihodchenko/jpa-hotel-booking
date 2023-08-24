package com.booking.jpahotelbooking.entity.dto.hotel;

import com.booking.jpahotelbooking.entity.Hotel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class HotelMapper {

    private final ModelMapper modelMapper;

    public HotelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public HotelResponseDTO convertToDto(Hotel entity) {
        return modelMapper.map(entity, HotelResponseDTO.class);
    }
}
