package com.booking.jpahotelbooking.service;

import com.booking.jpahotelbooking.entity.dto.room.RoomRequestDTO;
import com.booking.jpahotelbooking.entity.dto.room.RoomResponseDTO;
import com.booking.jpahotelbooking.exception.RoomStatusIsNotUpdatedException;
import org.springframework.web.server.ResponseStatusException;
import com.booking.jpahotelbooking.entity.dto.room.RoomMapper;
import com.booking.jpahotelbooking.repository.RoomRepository;
import jakarta.persistence.EntityNotFoundException;
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

    public List<RoomResponseDTO> getAll() {

        try {

            return roomRepository.findAllRoom();
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

            return roomRepository.updateStatusForRoom(id, status);
        }
        catch (EntityNotFoundException e) {

            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Room not found"
            );
        }
        catch (Exception e) {

            throw new RoomStatusIsNotUpdatedException(
                    "Failed to update room status"
            );
        }
    }
}