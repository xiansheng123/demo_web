package com.example.demo_web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.test.web.client.MockRestServiceServer;


@RestClientTest(PersonDBController.class)
public class PersonDBControllerTest {

    @Autowired
    private PersonDBController service;

    @Autowired
    private MockRestServiceServer server;

}