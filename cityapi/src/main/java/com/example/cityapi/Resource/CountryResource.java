package com.example.cityapi.Resource;


import com.example.cityapi.DTO.CountryDTO;
import com.example.cityapi.Entity.Country;
import com.example.cityapi.Service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CountryResource {

    private final CountryService service;
    Logger log = LoggerFactory.getLogger(CountryResource.class);

    public CountryResource(CountryService service) {
        this.service = service;
    }

    @GetMapping("/countries")
    public List<CountryDTO> cities() {
        return service.CoutryList();

    }
}