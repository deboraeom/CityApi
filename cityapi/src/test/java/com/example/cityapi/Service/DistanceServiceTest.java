package com.example.cityapi.Service;


import com.example.cityapi.Entity.City;
import com.example.cityapi.Enum.EarthRadius;
import com.example.cityapi.Mapper.CityMapper;
import com.example.cityapi.Repository.CityRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.geo.Point;

import java.util.*;

import static com.example.cityapi.Enum.EarthRadius.METERS;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class DistanceServiceTest {

    private final Long idfirstCity = 3L;
    private final Long idSecondCity = 4L;
    CityMapper personMapper = CityMapper.INSTANCE;

    City city1 = new City(1L, "Afonso Cláudio", "(-20.0778007507324,-41.1260986328125)",
            new Point(-20.0778007507324, -41.1260986328125));


    City city2 = new City(2L, "Fortaleza", "(-20.0778007507324,-43.1260986328125)",
            new Point(-20.0778007507324, -43.1260986328125));


    @Mock
    CityRepository cityRepository;

    @InjectMocks
    DistanceService distanceService;

    @Test
    void distanceUsingMath() {
        List<City> lista = new ArrayList<City>();
        Double expectedDistance = 209108.38184177558;
        lista.add(city1);
        lista.add(city2);
        when(cityRepository.findAllById((Arrays.asList(idfirstCity, idSecondCity)))).
                thenReturn(lista);
        Double valueToCompare = distanceService.distanceUsingMath(idfirstCity, idSecondCity, METERS);
        assertEquals(valueToCompare, expectedDistance);
    }

    @Test
    void distanceByPointsInMiles() {
        Double randomValueTODistance = 1.1;
        when(cityRepository.distanceByPoints(idSecondCity, idfirstCity)).thenReturn(randomValueTODistance);
        assertEquals(distanceService.distanceByPointsInMiles(idSecondCity, idfirstCity), randomValueTODistance);
    }

    @Test
    void distanceUsingPoints() {
        List<City> lista = new ArrayList<City>();
        Double expectedDistance = 209108.38184177558;
        lista.add(city1);
        lista.add(city2);
        when(cityRepository.findAllById((Arrays.asList(idfirstCity, idSecondCity)))).
                thenReturn(lista);
        Double valueToCompare = distanceService.distanceUsingPoints(idfirstCity, idSecondCity, METERS);
        assertEquals(valueToCompare, expectedDistance);

    }

    @Test
    void distanceByCubeInMeters() {
        List<City> lista = new ArrayList<City>();
        Double randomValueTODistance = 1.1;
        lista.add(city1);
        lista.add(city2);
        when(cityRepository.findAllById((Arrays.asList(idfirstCity, idSecondCity)))).
                thenReturn(lista);
        when(cityRepository.distanceByCube(city1.getLocation().getX(), city1.getLocation().getY(), city2.getLocation().getX(), city2.getLocation().getY())).thenReturn(randomValueTODistance);
        Double valueToCompare = distanceService.distanceByCubeInMeters(idfirstCity, idSecondCity);
        assertEquals(valueToCompare, randomValueTODistance);

    }

}