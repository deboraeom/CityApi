package com.example.cityapi.Resource;

import com.example.cityapi.Enum.EarthRadius;
import com.example.cityapi.Service.DistanceService;
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

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class DistanceResourceTest {
    private static final String DISTANCE_API_URL_PATH = "/distances";

    private final Long idfirstCity = 3L;
    private final Long idSecondCity = 4L;

    private MockMvc mockMvc;
    @Mock
    private DistanceService distanceService;


    @InjectMocks
    private DistanceResource distanceResource;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(distanceResource)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .setViewResolvers((s, locale) -> new MappingJackson2JsonView())
                .build();


    }

    @Test
    void byPoints() throws Exception {
        Double randomValueToReturn= 1.1;

        when(distanceService.distanceByPointsInMiles(idfirstCity,idSecondCity)).thenReturn(randomValueToReturn);
        mockMvc.perform(get(DISTANCE_API_URL_PATH+ "/by-points?from="+ idfirstCity+ "&to="+idSecondCity ))
                .andExpect(status().isOk());
    }

    @Test
    void byCube() throws Exception {
        Double randomValueToReturn= 1.1;

        when(distanceService.distanceByCubeInMeters(idfirstCity,idSecondCity)).thenReturn(randomValueToReturn);
        mockMvc.perform(get(DISTANCE_API_URL_PATH+ "/by-cube?from="+ idfirstCity+ "&to="+idSecondCity ))
                .andExpect(status().isOk());
    }

    @Test
    void byMath() throws Exception {
        Double randomValueToReturn= 1.1;

        when(distanceService.distanceUsingMath(idfirstCity,idSecondCity, EarthRadius.METERS)).thenReturn(randomValueToReturn);
        mockMvc.perform(get(DISTANCE_API_URL_PATH+ "/by-math?from="+ idfirstCity+ "&to="+idSecondCity +"&unit=METERS"))
                .andExpect(status().isOk());
    }
}