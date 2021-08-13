package com.example.cityapi.Resource;

import com.example.cityapi.DTO.StateDTO;
import com.example.cityapi.Service.StateService;
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
class StateResourceTest {

    private static final String STATE_API_URL_PATH = "/state";
    StateDTO stateDTO = new StateDTO();

    private MockMvc mockMvc;
    @Mock
    private StateService stateService;


    @InjectMocks
    private StateResource stateResource;

    @BeforeEach
    void setUp(){
        mockMvc= MockMvcBuilders.standaloneSetup(stateResource)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .setViewResolvers((s, locale) -> new MappingJackson2JsonView())
                .build();
    }
    @Test
    void whenGetListIsCalledThenReturnAListAndReturnStatusOk() throws Exception {

        when(stateService.StateList()).thenReturn(Collections.singletonList(stateDTO));
        mockMvc.perform(get(STATE_API_URL_PATH))
                .andExpect(status().isOk());
    }

    @Test
    void whenGetListIsCalledThenReturnAListEmptyAndReturnStatusOk() throws Exception {

        when(stateService.StateList()).thenReturn(Collections.emptyList());
        mockMvc.perform(get(STATE_API_URL_PATH))
                .andExpect(status().isOk());
    }}
