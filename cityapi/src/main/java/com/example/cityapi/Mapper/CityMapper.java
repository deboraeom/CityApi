package com.example.cityapi.Mapper;

import com.example.cityapi.DTO.CityDTO;
import com.example.cityapi.Entity.City;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CityMapper {
    CityMapper INSTANCE= Mappers.getMapper(CityMapper.class);
    final CityMapper cityMapper = CityMapper.INSTANCE;

    City toModel(CityDTO cityDTO);

    CityDTO toDTO(City city);
}
