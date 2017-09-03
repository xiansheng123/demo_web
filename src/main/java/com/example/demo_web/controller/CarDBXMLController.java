package com.example.demo_web.controller;

import com.example.demo_web.dto.CarDTO;
import com.example.demo_web.respository.CarDBRespository;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/CarXml")
public class CarDBXMLController {
    @Autowired
    private CarDBRespository carDBXMLRespository;

    @PostMapping(value = "/checkoneCar",consumes = { MediaType.APPLICATION_XML_VALUE} )
    public CarDTO getCarbyID(@RequestBody  String car) {
      try   {
           XmlMapper mapper = new XmlMapper();
          CarDTO c = mapper.readValue(car, CarDTO.class);
          return c;
      }
      catch ( Exception ex)
      {
           throw  new RuntimeException();
      }

    }
}
