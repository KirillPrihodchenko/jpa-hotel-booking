package com.booking.jpahotelbooking.service;

import com.booking.jpahotelbooking.entity.Registration;
import com.booking.jpahotelbooking.entity.dto.registration.RegistrationMapper;
import com.booking.jpahotelbooking.entity.dto.registration.RegistrationRequestDTO;
import com.booking.jpahotelbooking.repository.RegistrationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RegistrationService {

    private final RegistrationRepository registrationRepository;
    private final RegistrationMapper registrationMapper;

    public RegistrationService(RegistrationRepository registrationRepository, RegistrationMapper registrationMapper) {
        this.registrationRepository = registrationRepository;
        this.registrationMapper = registrationMapper;
    }

    public List<Registration> getAllRegistration() {
        return registrationRepository.findAll();
    }

    public Registration addRegistration(RegistrationRequestDTO registrationRequestDTO) {
        Registration registration = registrationMapper.convertToEntity(registrationRequestDTO);
        return registrationRepository.save(registration);
    }

    public List<Registration> getRegistrationByTsCheckIn(LocalDateTime timeIn) {
        return registrationRepository.findRegistrationByTsCheckIn(timeIn)
                .orElseThrow(() -> new NoSuchElementException(
                        String.format("Registration with [%s] not found", timeIn.toString())
                ));
    }
}