package com.example.cityapi.Service;


import com.example.cityapi.DTO.StateDTO;
import com.example.cityapi.Entity.State;
import com.example.cityapi.Mapper.CityMapper;
import com.example.cityapi.Mapper.StateMapper;
import com.example.cityapi.Repository.StateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StateService {
    private final com.example.cityapi.Repository.StateRepository stateRepository;
    Logger log = LoggerFactory.getLogger(StateService.class);
    private final StateMapper stateMapper = StateMapper.INSTANCE;

    public StateService(final StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }


    public List<StateDTO> StateList() {
        return stateRepository.findAll().stream().map(stateMapper::toDTO).collect(Collectors.toList());

    }
}


