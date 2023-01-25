package com.example.demo.controller;

import com.example.demo.json.Greeting;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloRestControllerFunctionalTest {

    /*
     * Note that the template could instead be declared as an argument of the test method(s).
     * e.g.
     * @Test
     * public void greetWithName(@Autowired TestRestTemplate template) {
     *     ...
     * }
     */
    @Autowired
    private TestRestTemplate template;

    @Test
    public void greetWithName() {
        Greeting response = template.getForObject("/rest?name=Russell", Greeting.class);
        assertEquals("Hello, Russell!", response.message());
    }

    @Test
    public void greetWithoutName() {
        ResponseEntity<Greeting> entity = template.getForEntity("/rest", Greeting.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, entity.getStatusCode()),
                () -> assertEquals(MediaType.APPLICATION_JSON, entity.getHeaders().getContentType())
        );

        Greeting response = entity.getBody();
        assertAll(
                () -> assertNotNull(response),
                () -> assertEquals("Hello, World!", response.message())
        );
    }
}