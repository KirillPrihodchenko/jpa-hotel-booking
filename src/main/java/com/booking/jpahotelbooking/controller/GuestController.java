package com.booking.jpahotelbooking.controller;

import com.booking.jpahotelbooking.entity.dto.guest.GuestRequestDTO;
import org.springframework.validation.annotation.Validated;
import com.booking.jpahotelbooking.service.GuestService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor

@RestController
@RequestMapping("/guests")
public class GuestController {

    private final GuestService guestService;

    @GetMapping
    public ResponseEntity<?> getAll() {

        return new ResponseEntity<>(
                guestService.getAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/by")
    public ResponseEntity<?> byLastName(@RequestParam @Validated String lastName) {

        return new ResponseEntity<>(
                guestService.getByLastName(lastName),
                HttpStatus.OK
        );
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody GuestRequestDTO requestDTO) {

        return new ResponseEntity<>(
                guestService.createGuest(requestDTO),
                HttpStatus.CREATED
        );
    }

    @PatchMapping("{id}/update")
    public ResponseEntity<?> update(
                    @PathVariable Long id,
                    @RequestBody @Validated GuestRequestDTO requestDTO) {

        return new ResponseEntity<>(
                guestService.updateGuest(id, requestDTO),
                HttpStatus.OK
        );
    }

    @DeleteMapping("{id}/delete")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        return new ResponseEntity<>(
                guestService.deleteGuestById(id),
                HttpStatus.OK
        );
    }
}