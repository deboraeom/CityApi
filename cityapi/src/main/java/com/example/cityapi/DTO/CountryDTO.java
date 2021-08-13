package com.example.cityapi.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CountryDTO {

    private Long id;

    private String name;

    private String portugueseName;

    private String code;

    private Integer bacen;
}
