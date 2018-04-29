package com.example.demo_web.service;

import com.example.demo_web.Entity.SystemCode;
import com.example.demo_web.Entity.TabTest;
import com.example.demo_web.dto.PersonDTO;
import com.example.demo_web.respository.SystemCodeDBRepository;
import com.example.demo_web.respository.TabTestRepository;
import lombok.AllArgsConstructor;
import org.hibernate.validator.constraints.EAN;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TabTestService {
    private TabTestRepository tabTestRepo;
    private SystemCodeDBRepository systemCodeDBRepo;

    public TabTest getCountryById(Integer id){
      return tabTestRepo.findOne (id);
    }

    public SystemCode getSystemCodeById(Integer id){
         return systemCodeDBRepo.findOne (id);
    }
}
