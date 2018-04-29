package com.example.demo_web.service;

import com.example.demo_web.Entity.TabTest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonDBService {
    private TabTestService tabTestService;

    public TabTest getCodeByTabTest(int id){
        return tabTestService.getCountryById (id);
    }
}
