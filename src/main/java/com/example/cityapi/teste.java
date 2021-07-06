package com.example.cityapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class teste {

    @GetMapping("/")
    public String retornaTest(){
        return "helloWorld";
    }


}
