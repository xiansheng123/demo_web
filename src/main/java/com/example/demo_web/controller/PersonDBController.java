package com.example.demo_web.controller;

import com.example.demo_web.dto.PersonDTO;
import com.example.demo_web.dto.PersonAndSystemCode;
import com.example.demo_web.dto.SystemCodeDTO;
import com.example.demo_web.Entity.PersonDB;
import com.example.demo_web.Entity.SystemCode;
import com.example.demo_web.service.PersonDBRepository;
import com.example.demo_web.service.SystemCodeDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
        return  entity;//ConvertLongDate(entity.stream().filter(x -> x.getId() == 64).findFirst().get().getAddedDate2());
    }

    @RequestMapping(value = "/getDate")
    public String getDate() {
        Timestamp aa = ConvertTimeStamp("2017-11-14 09:35:44:123+08:00");
        return ConvertLongDate(aa);
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

    @RequestMapping(value = "/getPersonByName/{Name}")
    public List<PersonDB> getOneByName(@PathVariable("Name") String name) {
        List<PersonDB> entity = personServiceDB.findByName(name);
        // System.out.println(personServiceDB.findByName("tom"));

        if (entity==null)
        {return  null   ;}
        if(entity.isEmpty())
        { entity.add(new PersonDB(18,"noperson"));
        }
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
        PersonDB person = new PersonDB("ZouXuan", 27, false);
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

    //update and insert
    //  @RequestMapping(method = RequestMethod.POST ,value = "/addPerson")
    @PostMapping(value = "/addPerson")
    public String AddPerson( @RequestBody PersonDB person) {

//        if (br.hasErrors()) {
//            return "Validate failed :";//+br.getAllErrors();
//        } else {
            personServiceDB.save(person);
            return "save Successfully ";
  //      }

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

    private String ConvertLongDate(Timestamp timestamp) {
        SimpleDateFormat stf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSZ");
        Date date = new Date(timestamp.getTime());
        return stf.format(date);
    }

    private Timestamp ConvertTimeStamp(String time) {

        SimpleDateFormat stf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        Timestamp timestamp = new Timestamp(stf.parse(time, new ParsePosition(0)).getTime());
        return timestamp;
    }

}


