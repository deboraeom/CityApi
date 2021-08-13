package com.example.cityapi.Service;

import com.example.cityapi.DTO.CountryDTO;
import com.example.cityapi.Mapper.CityMapper;
import com.example.cityapi.Mapper.CountryMapper;
import com.example.cityapi.Repository.CountryRepository;
import com.example.cityapi.Entity.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryService {
    private final com.example.cityapi.Repository.CountryRepository CountryRepository;
    Logger log = LoggerFactory.getLogger(CountryService.class);
    private final CountryMapper countryMapper = CountryMapper.INSTANCE;

    public CountryService(final CountryRepository CountryRepository) {
        this.CountryRepository = CountryRepository;
    }


    public List<CountryDTO> CoutryList() {

       return CountryRepository.findAll().stream()
               .map(countryMapper::toDTO)
               .collect(Collectors.toList());
    }
}
