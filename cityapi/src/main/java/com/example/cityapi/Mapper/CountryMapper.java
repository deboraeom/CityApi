package com.example.cityapi.Mapper;

import com.example.cityapi.DTO.CountryDTO;

import com.example.cityapi.Entity.Country;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CountryMapper {
    CountryMapper INSTANCE= Mappers.getMapper(CountryMapper.class);
    final CountryMapper stataMapper = CountryMapper.INSTANCE;

    CountryDTO toDTO(Country country);

    Country toModel(CountryDTO countryDTO);
}
