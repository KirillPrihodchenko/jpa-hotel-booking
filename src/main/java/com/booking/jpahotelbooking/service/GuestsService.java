package com.booking.jpahotelbooking.service;

import com.booking.jpahotelbooking.entity.Guests;
import com.booking.jpahotelbooking.entity.dto.guest.GuestMapper;
import com.booking.jpahotelbooking.entity.dto.guest.GuestRequestDTO;
import com.booking.jpahotelbooking.repository.GuestsRepository;
import org.springframework.stereotype.Service;

@Service
public class GuestsService {

    private final GuestsRepository guestsRepository;
    private final GuestMapper guestMapper;

    public GuestsService(GuestsRepository guestsRepository, GuestMapper guestMapper) {
        this.guestsRepository = guestsRepository;
        this.guestMapper = guestMapper;
    }

    public Iterable<Guests> getAll() {
        return guestsRepository.findAll();
    }

    public Guests createGuest(GuestRequestDTO guestsRequestDTO) {
        Guests guests = guestMapper.convertToEntity(guestsRequestDTO);
        return guestsRepository.save(guests);
    }

    public void deleteGuestById(Long id) {
        guestsRepository.deleteById(id);
    }
}