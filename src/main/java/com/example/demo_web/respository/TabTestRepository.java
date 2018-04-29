package com.example.demo_web.respository;

import com.example.demo_web.Entity.TabTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TabTestRepository extends JpaRepository<TabTest, Integer> {
}


