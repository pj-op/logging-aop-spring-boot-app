package com.logging.app.service.impl;

import com.logging.app.exceptions.IncorrectArgException;
import com.logging.app.service.GreetService;
import org.springframework.stereotype.Service;

@Service
public class GreetServiceImpl implements GreetService {
    @Override
    public String greetPerson(String personName) {
        if (personName.equalsIgnoreCase("test-failure")) {
            throw new IncorrectArgException(personName + " is not acceptable");
        }
        return "Hi! " + personName + " Welcome to my Application";
    }
}
