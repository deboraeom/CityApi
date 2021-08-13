package com.example.cityapi.Service;
import com.example.cityapi.DTO.StateDTO;
import com.example.cityapi.Entity.State;
import com.example.cityapi.Mapper.StateMapper;
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
class StateServiceTest {
    private final Long id = 1L;
    StateMapper stateMapper = StateMapper.INSTANCE;

    StateDTO stateDTO = StateDTO.builder()
            .id(1L)
            .name("Salvador")
            .build();

    @Mock
    StateRepository stateRepository;

    @InjectMocks
    StateService stateService;

    @Test
    public void whenRequestAllStateReturnList(){

        State stateTOSave = stateMapper.toModel(stateDTO);
        when(stateRepository.findAll()).thenReturn(Collections.singletonList(stateTOSave));
        assertThat(stateService.StateList(), CoreMatchers.is(equalTo(Collections.singletonList(stateMapper.toDTO(stateTOSave)))));

    }

    @Test
    public void whenRequestAllStateReturnEmptyList(){

        State stateTO = stateMapper.toModel(stateDTO);
        when(stateRepository.findAll()).thenReturn(Collections.emptyList());

        assertThat(stateService.StateList(),CoreMatchers.is(equalTo(Collections.emptyList())));}

    }
