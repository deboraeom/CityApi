package com.example.cityapi.Country;

import com.example.cityapi.City.CityRepository;
import com.example.cityapi.City.DistanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    private final CountryRepository CountryRepository;
    Logger log = LoggerFactory.getLogger(CountryService.class);

    public CountryService(final CountryRepository CountryRepository) {
        this.CountryRepository = CountryRepository;
    }


    public List<Country> CoutryList() {

       return CountryRepository.findAll();
    }
}
