package com.example.cityapi.Service;

import com.example.cityapi.DTO.CityDTO;
import com.example.cityapi.Entity.City;
import com.example.cityapi.Mapper.CityMapper;
import com.example.cityapi.Repository.CityRepository;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.geo.Point;

import java.util.Collections;

import static com.example.cityapi.Mapper.CityMapper.cityMapper;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CityServiceTest {
    private final Long id = 1L;
    CityMapper personMapper = CityMapper.INSTANCE;

    CityDTO cityDTO = CityDTO.builder()
            .id(1L)
            .name("Afonso Cláudio")
            .geolocation("(-20.0778007507324,-41.1260986328125)")
            .location(new Point(-20.0778007507324,-41.1260986328125))
            .build();



    @Mock
    CityRepository cityRepository;

    @InjectMocks
    CityService cityService;

    @Test
    public void whenRequestAllCityReturnList(){

        City cityTOSave = cityMapper.toModel(cityDTO);
        when(cityRepository.findAll()).thenReturn(Collections.singletonList(cityTOSave));
        assertThat(cityService.CityList(), CoreMatchers.is(equalTo(Collections.singletonList(cityMapper.toDTO(cityTOSave)))));

    }

    @Test
    public void whenRequestAllCityReturnEmptyList(){

        City cityTO = cityMapper.toModel(cityDTO);
        when(cityRepository.findAll()).thenReturn(Collections.emptyList());

        assertThat(cityService.CityList(),CoreMatchers.is(equalTo(Collections.emptyList())));

    }

}