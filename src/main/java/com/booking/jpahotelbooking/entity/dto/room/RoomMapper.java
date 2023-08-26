package com.booking.jpahotelbooking.entity.dto.room;

import com.booking.jpahotelbooking.entity.Room;
import com.booking.jpahotelbooking.mapper.GenericMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RoomMapper implements GenericMapper<RoomRequestDTO, RoomResponseDTO, Room> {

    private final ModelMapper modelMapper;

    public RoomMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;

    }

    @Override
    public RoomResponseDTO convertToDto(Room entity) {
        return modelMapper.map(entity, RoomResponseDTO.class);
    }

    @Override
    public Room convertToEntity(RoomRequestDTO roomsRequestDTO) {
        return modelMapper.map(roomsRequestDTO, Room.class);
    }
}