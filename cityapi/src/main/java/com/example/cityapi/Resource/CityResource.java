package com.example.cityapi.Resource;

import com.example.cityapi.DTO.CityDTO;
import com.example.cityapi.Entity.City;
import com.example.cityapi.Service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

 @RestController
public class CityResource {
    private final CityService service;
    Logger log = LoggerFactory.getLogger(CityResource.class);

    public CityResource(CityService service) {
        this.service = service;
    }

    @GetMapping("/city")
    public List<CityDTO> cities() {
        return service.CityList();

    }


}

