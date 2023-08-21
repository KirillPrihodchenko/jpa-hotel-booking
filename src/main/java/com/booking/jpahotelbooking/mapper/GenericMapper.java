package com.booking.jpahotelbooking.mapper;

public interface GenericMapper<reqDTO, resDTO, E> {

    resDTO convertToDto(E entity);

    E convertToEntity(reqDTO dto);
}