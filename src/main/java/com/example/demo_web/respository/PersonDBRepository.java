package com.example.demo_web.respository;

import com.example.demo_web.Entity.PersonDB;
import com.example.demo_web.Entity.SystemCode;
import org.hibernate.annotations.Cache;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonDBRepository extends JpaRepository<PersonDB, Integer> {
    List<PersonDB> findByAge(Integer age);
   // List<PersonDB> findByName(String name);
    PersonDB findFirstByAge(Integer age);
    List<PersonDB> findFirst10ByAge(Integer age);
    PersonDB findTopByAge(Integer age);

    @Cacheable("cache2")
    PersonDB findOneByCountryCode(SystemCode systemCode);
    //@Cacheable("cache1")
    PersonDB findOneByName(String name);
    PersonDB findByName(String name);

    @Procedure(name="Demo_Test")
    void Demo_Test(@Param("Name") String name,@Param("Age") Integer age);
    @Procedure(name="Demo_Test_out" )
    String Demo_Test_out(@Param("Name") String name, @Param("Age") Integer age);

}


