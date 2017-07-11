package com.example.demo_web.service;

import com.example.demo_web.model.PersonDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


/**
 * Created by luxuda on 6/20/2017.
 */
@Repository
public interface PersonDBRepository extends JpaRepository<PersonDB, Integer> {
    //   List<PersonDB> findByAge(Integer name);
    List<PersonDB> findById(int id);

    List<PersonDB> findByName(String Name);

}


