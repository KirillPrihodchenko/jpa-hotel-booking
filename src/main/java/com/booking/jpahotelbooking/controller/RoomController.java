package com.booking.jpahotelbooking.controller;

import com.booking.jpahotelbooking.entity.dto.room.RoomRequestDTO;
import com.booking.jpahotelbooking.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor

@RestController
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService roomService;

    @GetMapping
    public ResponseEntity<?> getAllRooms() {

        return new ResponseEntity<>(
                roomService.getAll(),
                HttpStatus.OK
        );
    }

    @PostMapping("/create")
    public ResponseEntity<?> createRoom(
            @RequestBody @Validated RoomRequestDTO requestDTO) {

        return new ResponseEntity<>(
                roomService.createRoom(requestDTO),
                HttpStatus.CREATED
        );
    }

    @PatchMapping("{id}/updateStatus")
    public ResponseEntity<?> updateStatus(
            @PathVariable Long id,
            @RequestParam @Validated Boolean status) {

        return new ResponseEntity<>(
                roomService.updateOnlyStatus(id, status),
                HttpStatus.OK
        );
    }
}