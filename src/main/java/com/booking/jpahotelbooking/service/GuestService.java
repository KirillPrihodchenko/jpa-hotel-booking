package com.booking.jpahotelbooking.service;

import com.booking.jpahotelbooking.entity.Guest;
import com.booking.jpahotelbooking.entity.dto.guest.GuestMapper;
import com.booking.jpahotelbooking.entity.dto.guest.GuestRequestDTO;
import com.booking.jpahotelbooking.repository.GuestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor

@Service
public class GuestService {

    private final GuestRepository guestsRepository;
    private final GuestMapper guestMapper;

    public Iterable<Guest> getAll() {
        return guestsRepository.findAll();
    }

    public Guest createGuest(GuestRequestDTO guestsRequestDTO) {
        Guest guests = guestMapper.convertToEntity(guestsRequestDTO);
        return guestsRepository.save(guests);
    }

    public void deleteGuestById(Long id) {
        guestsRepository.deleteById(id);
    }
}