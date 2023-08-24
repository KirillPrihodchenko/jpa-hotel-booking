package com.booking.jpahotelbooking.service;

import com.booking.jpahotelbooking.entity.Room;
import com.booking.jpahotelbooking.entity.dto.room.RoomMapper;
import com.booking.jpahotelbooking.entity.dto.room.RoomRequestDTO;
import com.booking.jpahotelbooking.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor

@Service
public class RoomService {

    private final RoomRepository roomsRepository;
    private final RoomMapper roomsMapper;

    public List<Room> getAll() {
        return roomsRepository.findAll();
    }

    public Room createRooms(RoomRequestDTO roomsRequestDTO) {
        Room rooms = roomsMapper.convertToEntity(roomsRequestDTO);
        return roomsRepository.save(rooms);
    }
}
