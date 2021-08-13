package com.example.cityapi.state;
import java.util.List;


import com.example.cityapi.Country.Country;
import com.example.cityapi.Country.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StateResource {

    private final StateService service;
    Logger log = LoggerFactory.getLogger(StateResource.class);

    public StateResource(StateService service) {
        this.service = service;
    }

    @GetMapping("/state")
    public List<State> cities() {
        return service.StateList();

    }
}