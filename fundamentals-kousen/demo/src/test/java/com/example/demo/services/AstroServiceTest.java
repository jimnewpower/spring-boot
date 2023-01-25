package com.example.demo.services;

import com.example.demo.json.Assignment;
import com.example.demo.json.AstroResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AstroServiceTest {

    @Autowired
    private AstroService service;

    @Test
    void getAstronautsRest() {
        AstroResult result = service.getAstronautsRT();
        int number = result.number();
        System.out.println("There are " + number + " people in space.");
        List<Assignment> people = result.people();
        people.forEach(System.out::println);
        assertAll(
                () -> assertTrue(number >= 0),
                () -> assertEquals(number, people.size())
        );

    }

    @Test
    void getAstronautsWebClient() {
        AstroResult result = service.getAstronautsWC();
        int number = result.number();
        System.out.println("There are " + number + " people in space.");
        List<Assignment> people = result.people();
        people.forEach(System.out::println);
        assertAll(
                () -> assertTrue(number >= 0),
                () -> assertEquals(number, people.size())
        );

    }
}