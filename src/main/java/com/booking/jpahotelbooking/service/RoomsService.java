package com.booking.jpahotelbooking.service;

import com.booking.jpahotelbooking.entity.Rooms;
import com.booking.jpahotelbooking.entity.dto.room.RoomsMapper;
import com.booking.jpahotelbooking.entity.dto.room.RoomsRequestDTO;
import com.booking.jpahotelbooking.repository.RoomsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomsService {

    private final RoomsRepository roomsRepository;
    private final RoomsMapper roomsMapper;

    public RoomsService(RoomsRepository roomsRepository, RoomsMapper roomsMapper) {
        this.roomsRepository = roomsRepository;
        this.roomsMapper = roomsMapper;
    }

    public List<Rooms> getAll() {
        return roomsRepository.findAll();
    }

    public Rooms createRooms(RoomsRequestDTO roomsRequestDTO) {
        Rooms rooms = roomsMapper.convertToEntity(roomsRequestDTO);
        return roomsRepository.save(rooms);
    }
}
