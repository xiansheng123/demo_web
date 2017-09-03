package com.example.demo_web;

import com.example.demo_web.respository.PersonDBRepository;
import com.example.demo_web.respository.SystemCodeDBRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
//@SpringApplicationConfiguration(classes = DemoApplication.class)
public class DemoWebApplicationTests {

	@Autowired
	SystemCodeDBRepository systemCodeDBRepository  ;
	@Autowired
	PersonDBRepository personDBRepository;

	@Test
	public void contextLoads() {
		 System.out.print( systemCodeDBRepository.findByCodename("ZouXuan"));
	}
	@Test
	public void FindoneSystemCode() {
		System.out.print( systemCodeDBRepository.findOne(1).getCodename().toString() );
	}

	@Test
	public void FindonePerson() {
		System.out.print( personDBRepository.findByAge(24).toString() );
	}

}
