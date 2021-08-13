package com.example.cityapi.Entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.geo.Point;


@Entity
@Table(name = "cidade")
@TypeDefs(value = {
        @TypeDef(name = "point", typeClass = PointType.class)
})

public class City {

    @Id
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(name = "lat_lon")
    private String geolocation;

    // 2nd
    @Type(type = "point")
    @Column(name = "lat_lon", updatable = false, insertable = false)
    private Point location;

    public City() {
    }

    public City(final Long id, final String name,
                final String geolocation, final Point location) {
        this.id = id;
        this.name = name;

        this.geolocation = geolocation;
        this.location = location;
    }


    public City(final Long id, final String name){
        this.id = id;
        this.name = name;


    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public String getGeolocation() {
        return geolocation;
    }

    public Point getLocation() {
        return location;
    }
}