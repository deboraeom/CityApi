package com.example.cityapi.state;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StateService {
    private final StateRepository StateRepository;
    Logger log = LoggerFactory.getLogger(StateService.class);

    public StateService(final StateRepository StateRepository) {
        this.StateRepository = StateRepository;
    }


    public List<State> StateList() {

        return StateRepository.findAll();
    }
}


