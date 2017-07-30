package com.example.demo_web.service;

/**
 * Created by luxuda on 6/13/2017.
 */

import org.springframework.stereotype.Service;
import com.example.demo_web.Entity.Person;
import java.util.Hashtable;

@Service
public class PersonService {
   private Hashtable<String,Person> persons=new Hashtable<String,Person>();
   private int mycount=4;
   public PersonService(){
       Person p=new Person();
       p.setId("1");
       p.setAge(21);
       p.setFirstname("Lu");
       p.setLastname("XUDA");
       this.persons.put("1",p);

       p=new Person();
       p.setId("2");
       p.setAge(22);
       p.setFirstname("Zou");
       p.setLastname("Xuan");
       this.persons.put("2",p);

       p=new Person();
       p.setId("32");
       p.setAge(22);
       p.setFirstname("Da");
       p.setLastname("Peng");
       this.persons.put("3",p);
   }

   public Person getPerson(String id){
       if(persons.containsKey(id))
          return persons.get(id);
       else
           return null  ;
   }

   public Hashtable<String,Person> getAll(){
       return this.persons;
   }

  public  void addPerson (Person person){

       this.persons.put(Integer.toString(this.mycount),person);
       this.mycount=this.mycount+1;
  }
}
