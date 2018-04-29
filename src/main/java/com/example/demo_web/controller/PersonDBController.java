package com.example.demo_web.controller;

import com.example.demo_web.Entity.PersonDB;
import com.example.demo_web.Entity.SystemCode;
import com.example.demo_web.Util.Func;
import com.example.demo_web.dto.PersonAndSystemCode;
import com.example.demo_web.dto.PersonDTO;
import com.example.demo_web.dto.SystemCodeDTO;
import com.example.demo_web.respository.PersonDBRepository;
import com.example.demo_web.respository.SystemCodeDBRepository;
import com.example.demo_web.service.PersonDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
public class PersonDBController {

    @Autowired
    private PersonDBRepository personServiceDB;
    @Autowired
    private SystemCodeDBRepository systemCodeDBRepository;

    @RequestMapping(value = "/getPersons")
    public List<PersonDB> getAll() {
        List<PersonDB> entities = personServiceDB.findAll();
        return entities;//ConvertLongDate(entity.stream().filter(x -> x.getId() == 64).findFirst().get().getAddedDate2());
    }

    @RequestMapping(value = "/getDate")
    public String getDate() {
        Timestamp aa = Func.convertTimeStamp("2017-11-14 09:35:44:123+08:00");
        return Func.ConvertLongDate(aa);
    }


    @RequestMapping(value = "/getSystemCode")
    public List<SystemCode> getALLCodes() {
        List<SystemCode> entity = systemCodeDBRepository.findAll();
        return entity;
    }


    @RequestMapping(value = "/getPersonByAge/{Age}")
    public Object getOneByAge(@PathVariable("Age") Integer age) {
        PersonDB entity2 = personServiceDB.findFirstByAge(age);
        List<PersonDB> entity3 = personServiceDB.findByAge(age);
        if(entity3.isEmpty()) {
            return "is empty";}
        return entity2;
    }

    @RequestMapping(value = "/getPersonByName/{Name}")
    public Object getOneByName(@PathVariable("Name") String name) {
        PersonDB entity = personServiceDB.findOneByName (name);
        if (entity == null) {
            return "is empty";
        }
        return entity;
    }

    @RequestMapping(value = "/getPersonBySystemCode")
    public Object getOneBySystemCode() {
        PersonDB entity = personServiceDB.findOneByCountryCode (SystemCode
                .builder ()
                .id (11)
                .codename ("908")
                .build ()
        );
        return entity;
    }

    @RequestMapping(value = "/addZouXuan")
    public PersonDB AddHardPerson() {
        PersonDB person = PersonDB.builder()
                .name("ZouXuan")
                .age(13)
                .sex(false)
                .addedDate(new Timestamp(new Date().getTime()))
                .countryCode (SystemCode.builder()
                        .groupName("group")
                        //.codename("xu")
                        .build())
                .build();
        personServiceDB.save(person);
        System.out.println(person);
        return person;
    }
    @RequestMapping(value = "/runProcedure")
    public void RunProcedure() {
        personServiceDB.Demo_Test("benchi", 89);
        System.out.print("Successfully!");
    }

    @RequestMapping(value = "/runProcedureout")
    public Object RunProcedureout() {
        return personServiceDB.Demo_Test_out("benchiout", 90);
    }

    @PostMapping(value = "/personList")
    public Object AddPerson(@RequestBody PersonDTO person) {
        System.out.println (person.getSelect ());
        System.out.println (person.getDemo ());
        System.out.println (person.getName ());
        return person;
    }

    @GetMapping(value = "/getOnePerson/{id}")
    public Object getonePerson(@PathVariable("id") String id) {
        PersonDB personDB;
        try {
            personDB = personServiceDB.findOne(Integer.valueOf(id));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return  personDB.getCountryCode ();
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
        //systemCode.setCodename(req.getSystemCodeDTO().getCodename());
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


