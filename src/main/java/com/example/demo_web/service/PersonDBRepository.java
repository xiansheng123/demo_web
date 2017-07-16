package com.example.demo_web.service;

import com.example.demo_web.model.PersonDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


/**
 * Created by luxuda on 6/20/2017.
 */
@Repository
public interface PersonDBRepository extends JpaRepository<PersonDB, Integer> {
    //   List<PersonDB> findByAge(Integer name);
    List<PersonDB> findByAge(Integer Age);
    List<PersonDB> findByName(String Name);
    @Procedure(name="Demo_Test")
    void Demo_Test(@Param("Group1") String name,@Param("Age") Integer age);

    @Procedure(name="Demo_Test_out")
    String Demo_Test_out(@Param("Group1") String name, @Param("Age") Integer age);
}


