package com.example.cityapi.Mapper;

import com.example.cityapi.DTO.StateDTO;
import com.example.cityapi.Entity.State;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StateMapper {

    StateMapper INSTANCE= Mappers.getMapper(StateMapper.class);
    final StateMapper stataMapper = StateMapper.INSTANCE;

    State toModel(StateDTO stateDTO);

    StateDTO toDTO(State state);
}
