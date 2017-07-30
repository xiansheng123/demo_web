package com.example.demo_web.controller;

import com.example.demo_web.Util.Func;
import com.example.demo_web.dto.PersonDTO;
import com.example.demo_web.dto.PersonAndSystemCode;
import com.example.demo_web.dto.SystemCodeDTO;
import com.example.demo_web.Entity.PersonDB;
import com.example.demo_web.Entity.SystemCode;
import com.example.demo_web.service.PersonDBRepository;
import com.example.demo_web.service.SystemCodeDBRepository;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.xml.crypto.Data;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by luxuda on 6/20/2017.
 */
@RestController
public class PersonDBController {


    @Autowired
    private PersonDBRepository personServiceDB;
    @Autowired
    private SystemCodeDBRepository systemCodeDBRepository;

    @RequestMapping(value = "/getPersons")
    public List<PersonDB> getAll() {
        List<PersonDB> entity = personServiceDB.findAll();
        return entity;//ConvertLongDate(entity.stream().filter(x -> x.getId() == 64).findFirst().get().getAddedDate2());
    }

    @RequestMapping(value = "/getDate")
    public String getDate() {
        Timestamp aa = Func.ConvertTimeStamp("2017-11-14 09:35:44:123+08:00");
        return Func.ConvertLongDate(aa);
    }


    @RequestMapping(value = "/getSystemCode")
    public List<SystemCode> getALLCodes() {
        List<SystemCode> entity = systemCodeDBRepository.findAll();
        return entity;
    }

    @RequestMapping(value = "/getHardSystemCode")
    public List<SystemCode> getsystemCodes() {
        List<SystemCode> entity = systemCodeDBRepository.findByCodename("ZouXuan");
        return entity;
    }

    @RequestMapping(value = "/getPersonByAge/{Age}")
    public List<PersonDB> getOneByName(@PathVariable("Age") Integer age) {
        List<PersonDB> entity = personServiceDB.findByAge(age);
        // System.out.println(personServiceDB.findByName("tom"));
        return entity;
    }

    @RequestMapping(value = "/addHardPerson")
    public PersonDB AddHardPerson() {
        PersonDB person = PersonDB.builder().name("ZouXuan")
                .age(13)
                .sex(false)
                .AddedDate(new Timestamp(new Date().getTime()))
                .build();
        personServiceDB.save(person);
        return person;
    }

    @RequestMapping(value = "/runProcedure")
    public void RunProcedure() {
        personServiceDB.Demo_Test("benchi", 89);
        System.out.print("Successfully!");
    }

    @RequestMapping(value = "/runProcedureout")
    public String RunProcedureout() {
        return personServiceDB.Demo_Test_out("benchiout", 90);
    }

    @PostMapping(value = "/addPerson")
    public String AddPerson(@RequestBody @Validated PersonDB person, BindingResult br) {
        if (br.hasErrors()) {
            return "Validate failed :" + br.getAllErrors();
        } else {
            personServiceDB.save(person);
            return "save Successfully ";
        }
    }

    //update and insert
    //  @RequestMapping(method = RequestMethod.POST ,value = "/addPerson")
    @PostMapping(value = "/addPersonAndSystemCode")
    public String AddPersonAndSystemCode(@RequestBody PersonAndSystemCode req) {
        PersonDB personDB = new PersonDB();
        personDB.setName(req.getPersonDTO().getName());
        personDB.setAge(req.getPersonDTO().getAge());
        personServiceDB.save(personDB);

        SystemCode systemCode = new SystemCode();
        systemCode.setCodename(req.getSystemCodeDTO().getCodename());
        systemCode.setGroupName(req.getSystemCodeDTO().getGroupname());
        systemCodeDBRepository.save(systemCode);
        return "save Successfully ";
    }

    @RequestMapping(value = "/showDTOJason")
    public PersonAndSystemCode AddPersonAndSystemCode() {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setName("Zhangjie");
        personDTO.setAge(28);

        SystemCodeDTO systemCode = new SystemCodeDTO();
        systemCode.setCodename("red");
        systemCode.setGroupname("color");

        PersonAndSystemCode req = new PersonAndSystemCode();
        req.setPersonDTO(personDTO);
        req.setSystemCodeDTO(systemCode);
        return req;
    }



}


