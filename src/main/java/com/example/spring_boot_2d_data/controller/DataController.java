package com.example.spring_boot_2d_data.controller;

import com.example.spring_boot_2d_data.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DataController {

    private final DataService dataService;

    @GetMapping("/api/data/test")
    public String testResponse(){
        return dataService.testResponse();
    }

    @GetMapping("/api/data/kimje")
    public String testKimje(){
        return dataService.testKimje();
    }
}
