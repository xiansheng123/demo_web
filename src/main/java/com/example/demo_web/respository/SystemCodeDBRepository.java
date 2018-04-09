package com.example.demo_web.respository;


import com.example.demo_web.Entity.SystemCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SystemCodeDBRepository extends JpaRepository<SystemCode, Integer> {
    List<SystemCode> findByCodename(String codename );
}
