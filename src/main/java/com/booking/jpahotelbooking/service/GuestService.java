package com.booking.jpahotelbooking.service;

import com.booking.jpahotelbooking.entity.Guest;
import com.booking.jpahotelbooking.entity.dto.guest.GuestMapper;
import com.booking.jpahotelbooking.entity.dto.guest.GuestRequestDTO;
import com.booking.jpahotelbooking.repository.GuestRepository;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor

@Service
public class GuestService {

    private final GuestRepository guestRepository;
    private final GuestMapper guestMapper;

    public List<Guest> getAll() {

        try {

            return (List<Guest>) guestRepository.findAll();
        }
        catch (NoSuchElementException e) {

            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Guests not found", e);
        }
    }

    public Guest getByLastName(@NotBlank String lastName) {

        return guestRepository
                .findByLastName(lastName)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        String.format("Guest with last name [%s] not found", lastName)
                ));
    }

    public Guest createGuest(@NotNull GuestRequestDTO guestsRequestDTO) {

        try {

            Guest guests = guestMapper.convertToEntity(guestsRequestDTO);
            return guestRepository.save(guests);
        }
        catch (Exception e) {

            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    e.getMessage());
        }
    }

    public Long updateGuest(Long id, @NotNull GuestRequestDTO requestDTO) {

        try {

            Guest changedGuest = existGuest(id);

            changedGuest.setFirstName(requestDTO.getFirstName());
            changedGuest.setLastName(requestDTO.getLastName());
            changedGuest.setPhone(requestDTO.getPhone());
            guestRepository.save(changedGuest);

            return id;
        }
        catch (Exception e) {

            throw new ResponseStatusException (
                    HttpStatus.NOT_MODIFIED,
                    "Guest hasn't modified", e
            );
        }
    }

    public Long deleteGuestById(Long id) {

        try {

            guestRepository.deleteById(id);
            return id;
        }
        catch (ResponseStatusException e) {

            System.out.println("Status: " + HttpStatus.NO_CONTENT + " message: " + e.getMessage());
            return -1L;
        }
    }

    private Guest existGuest(Long id) {

        return guestRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        String.format("Guest with id [%d] not found", id)
                ));
    }
}