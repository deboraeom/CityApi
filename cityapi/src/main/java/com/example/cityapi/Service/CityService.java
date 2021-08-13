package com.example.cityapi.Service;

import com.example.cityapi.DTO.CityDTO;
import com.example.cityapi.Mapper.CityMapper;
import com.example.cityapi.Repository.CityRepository;
import com.example.cityapi.Entity.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {
    private final CityRepository cityRepository;
    private final CityMapper cityMapper = CityMapper.INSTANCE;

    Logger log = LoggerFactory.getLogger(CityService.class);



    public CityService(final CityRepository cityRepository) {

        this.cityRepository = cityRepository;
    }


    public List<CityDTO> CityList() {
        return cityRepository.findAll()
                .stream().map(cityMapper::toDTO)
                .collect(Collectors.toList());
    }
}
