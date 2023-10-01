package com.booking.jpahotelbooking.service;

import com.booking.jpahotelbooking.entity.dto.registration.RegistrationRequestDTO;
import com.booking.jpahotelbooking.entity.dto.registration.RegistrationMapper;
import com.booking.jpahotelbooking.repository.RegistrationRepository;
import org.springframework.web.server.ResponseStatusException;
import com.booking.jpahotelbooking.entity.Registration;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import lombok.AllArgsConstructor;

import java.util.NoSuchElementException;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor

@Service
public class RegistrationService {

    private final RegistrationRepository registrationRepository;
    private final RegistrationMapper registrationMapper;

    public List<Registration> getAllRegistration() {

        try {

            return registrationRepository.findAll();
        }
        catch (NoSuchElementException e) {

            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Registration not found", e
            );
        }
    }

    public Registration addRegistration(RegistrationRequestDTO registrationRequestDTO) {

        try {

            Registration registration =
                    registrationMapper.convertToEntity(registrationRequestDTO);

            return registrationRepository.save(registration);
        }
        catch (Exception e) {

            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    e.getMessage()
            );
        }
    }

    public List<Registration> getRegistrationByTsCheckIn(LocalDateTime timeIn) {

        return registrationRepository
                .findRegistrationByTsCheckIn(timeIn)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        String.format("Registration with [%s] not found", timeIn.toString())
                ));
    }
}