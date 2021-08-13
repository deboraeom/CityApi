package com.example.cityapi.Service;


import com.example.cityapi.DTO.CountryDTO;
import com.example.cityapi.Entity.Country;
import com.example.cityapi.Mapper.CountryMapper;
import com.example.cityapi.Repository.CountryRepository;
import com.example.cityapi.Repository.StateRepository;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class CountryServiceTest {
    private final Long id = 1L;
    CountryMapper countryMapper = CountryMapper.INSTANCE;

    CountryDTO countryDTO = CountryDTO.builder()
            .id(1L)
            .name("Salvador")
            .build();

    @Mock
    CountryRepository countryRepository;

    @InjectMocks
    CountryService countryService;

    @Test
    public void whenRequestAllCountryReturnList(){

        Country countryTOSave = countryMapper.toModel(countryDTO);
        when(countryRepository.findAll()).thenReturn(Collections.singletonList(countryTOSave));
        assertThat(countryService.CoutryList(), CoreMatchers.is(equalTo(Collections.singletonList(countryMapper.toDTO(countryTOSave)))));

    }

    @Test
    public void whenRequestAllCountryReturnEmptyList(){

        Country countryTO = countryMapper.toModel(countryDTO);
        when(countryRepository.findAll()).thenReturn(Collections.emptyList());

        assertThat(countryService.CoutryList(),CoreMatchers.is(equalTo(Collections.emptyList())));

    }}

