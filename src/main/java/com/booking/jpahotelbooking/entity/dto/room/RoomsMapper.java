package com.booking.jpahotelbooking.entity.dto.room;

import com.booking.jpahotelbooking.entity.Rooms;
import com.booking.jpahotelbooking.mapper.GenericMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RoomsMapper implements GenericMapper<RoomsRequestDTO, RoomsResponseDTO, Rooms> {

    private final ModelMapper modelMapper;

    public RoomsMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public RoomsResponseDTO convertToDto(Rooms entity) {
        return modelMapper.map(entity, RoomsResponseDTO.class);
    }

    @Override
    public Rooms convertToEntity(RoomsRequestDTO roomsRequestDTO) {
        return modelMapper.map(roomsRequestDTO, Rooms.class);
    }
}