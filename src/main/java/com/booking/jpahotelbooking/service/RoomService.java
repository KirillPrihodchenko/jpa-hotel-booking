package com.booking.jpahotelbooking.service;

import com.booking.jpahotelbooking.entity.dto.room.RoomRequestDTO;
import org.springframework.web.server.ResponseStatusException;
import com.booking.jpahotelbooking.entity.dto.room.RoomMapper;
import com.booking.jpahotelbooking.repository.RoomRepository;
import com.booking.jpahotelbooking.entity.Room;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import lombok.AllArgsConstructor;

import java.util.NoSuchElementException;
import java.util.List;

@AllArgsConstructor

@Service
public class RoomService {

    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    public List<Room> getAll() {

        try {

            return roomRepository.findAll();
        }
        catch (NoSuchElementException e) {

            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Rooms not found", e);
        }
    }

    public Room createRoom(RoomRequestDTO roomsRequestDTO) {

        try {

            Room rooms = roomMapper.convertToEntity(roomsRequestDTO);
            if (roomsRequestDTO.getStatus() == null) {
                roomsRequestDTO.setStatus(false);
            }
            return roomRepository.save(rooms);
        }
        catch (Exception e) {

            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Room hasn't created", e
            );
        }
    }

    public Room updateOnlyStatus(Long id, Boolean status) {

        try {

            Room room = existRoom(id);

            // getStatus() returned entity with field setRoomStatus()
            room.getRoomsStatus().setRoomStatus(status);
            return roomRepository.save(room);
        }
        catch (Exception e) {

            throw new ResponseStatusException(
                    HttpStatus.NOT_MODIFIED,
                    "Room status hasn't modified"
            );
        }
    }

    private Room existRoom(Long id) {

        return roomRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        String.format("Room with id [%d] not found", id)
                ));
    }
}