package com.booking.jpahotelbooking.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.booking.jpahotelbooking.exception.GuestNotModifiedException;
import com.booking.jpahotelbooking.entity.dto.guest.GuestRequestDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import com.booking.jpahotelbooking.repository.GuestRepository;
import com.booking.jpahotelbooking.entity.Guest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;

import java.util.NoSuchElementException;
import java.util.List;

@RequiredArgsConstructor

@Service
public class GuestService implements UserDetailsService {

    private final GuestRepository guestRepository;

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

            Guest createdGuest = new Guest();

            createdGuest.setFirstName(guestsRequestDTO.getFirstName());
            createdGuest.setLastName(guestsRequestDTO.getLastName());
            createdGuest.setPhone(guestsRequestDTO.getPhone());
            createdGuest.setEmail(guestsRequestDTO.getEmail());
            createdGuest.setPassword(guestsRequestDTO.getPassword());
            createdGuest.setPassportInfo(guestsRequestDTO.getPassportInfo());

            return guestRepository.save(createdGuest);
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
            changedGuest.setEmail(requestDTO.getEmail());
            changedGuest.setPassword(requestDTO.getPassword());
            changedGuest.setPassportInfo(requestDTO.getPassportInfo());
            guestRepository.save(changedGuest);

            return id;
        }
        catch (Exception e) {

            throw new GuestNotModifiedException(
                    "Guest hasn't modified"
            );
        }
    }

    public String deleteGuestById(Long id) {

        try {

            guestRepository.deleteById(id);
            return "Employee has deleted successfully";
        }
        catch (ResponseStatusException e) {

            return "Status: " + HttpStatus.NO_CONTENT + " message: " + e.getMessage();
        }
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Guest guest = guestRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format("Guest with [%s] not found", username)
                ));

        return new User(
                guest.getEmail(),
                guest.getPassword(),
                guest.getRole().stream().map(role -> new SimpleGrantedAuthority(role.getRoleType())).toList()
        );
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