package com.example.cityapi.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.data.geo.Point;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CityDTO {

    private Long id;

    private String name;

    private String geolocation;

    private Point location;

    public CityDTO(final Long id, final String name, final Integer uf, final Integer ibge,
                final String geolocation, final Point location) {
        this.id = id;
        this.name = name;
        this.geolocation = geolocation;
        this.location = location;
    }


    public CityDTO(final Long id, final String name){
        this.id = id;
        this.name = name;


    }
}
