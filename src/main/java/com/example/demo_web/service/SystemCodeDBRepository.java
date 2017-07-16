package com.example.demo_web.service;


import com.example.demo_web.model.SystemCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by luxuda on 7/16/2017.
 */
@Repository
public interface SystemCodeDBRepository extends JpaRepository<SystemCode, Integer> {
    List<SystemCode> findByCodename(String codename );
}
