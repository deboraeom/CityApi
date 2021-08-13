package com.example.cityapi.Resource;
import java.util.List;


import com.example.cityapi.DTO.StateDTO;
import com.example.cityapi.Entity.State;
import com.example.cityapi.Service.StateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StateResource {

    private final StateService service;
    Logger log = LoggerFactory.getLogger(StateResource.class);

    public StateResource(StateService service) {
        this.service = service;
    }

    @GetMapping("/state")
    public List<StateDTO> cities() {
        return service.StateList();

    }
}