package com.example.cityapi.DTO;

import com.example.cityapi.Entity.Country;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StateDTO {


    private Long id;

    private String name;

    private String uf;

    private Integer ibge;

    private Country country;

    private List<Integer> ddd;
}
