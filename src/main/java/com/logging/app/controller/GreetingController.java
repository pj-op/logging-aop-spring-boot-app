package com.logging.app.controller;

import com.logging.app.service.GreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greet")
public class GreetingController {

    @Autowired
    private GreetService greetServiceImpl;

    @GetMapping(value = "/hello/{personName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> greetPerson(@PathVariable(name = "personName") String name) {
        return ResponseEntity.ok(greetServiceImpl.greetPerson(name));
    }
}
