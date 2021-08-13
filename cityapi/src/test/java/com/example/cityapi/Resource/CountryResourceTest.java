package com.example.cityapi.Resource;


import com.example.cityapi.DTO.CountryDTO;

import com.example.cityapi.Service.CountryService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class CountryResourceTest {

    private static final String COUNTRY_API_URL_PATH = "/countries";
    CountryDTO countryDTO = new CountryDTO();

    private MockMvc mockMvc;
    @Mock
    private CountryService countryService;


    @InjectMocks
    private CountryResource countryResource;

    @BeforeEach
    void setUp(){
        mockMvc= MockMvcBuilders.standaloneSetup(countryResource)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .setViewResolvers((s, locale) -> new MappingJackson2JsonView())
                .build();
    }
    @Test
    void whenGetListIsCalledThenReturnAListAndReturnStatusOk() throws Exception {

        when(countryService.CoutryList()).thenReturn(Collections.singletonList(countryDTO));
        mockMvc.perform(get(COUNTRY_API_URL_PATH))
                .andExpect(status().isOk());
    }

    @Test
    void whenGetListIsCalledThenReturnAListEmptyAndReturnStatusOk() throws Exception {

        when(countryService.CoutryList()).thenReturn(Collections.emptyList());
        mockMvc.perform(get(COUNTRY_API_URL_PATH))
                .andExpect(status().isOk());


    }


}