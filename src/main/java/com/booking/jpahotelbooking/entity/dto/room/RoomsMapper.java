package com.booking.jpahotelbooking.entity.dto.room;

import com.booking.jpahotelbooking.entity.Rooms;
import com.booking.jpahotelbooking.mapper.GenericMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RoomsMapper implements GenericMapper<RoomsDTO, Rooms> {

    private final ModelMapper modelMapper;

    public RoomsMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public RoomsDTO convertToDto(Rooms entity) {
        return modelMapper.map(entity, RoomsDTO.class);
    }
}
