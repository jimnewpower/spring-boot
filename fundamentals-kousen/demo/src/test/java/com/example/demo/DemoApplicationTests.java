package com.example.demo;

import com.example.demo.json.Greeting;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private ApplicationContext context;

    @Test
    void contextLoads() {
        assertNotNull(context);

        context.getBeanDefinitionCount();
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }

    @Test
    void noGreetingBeanInApplicationContext() {
        // Would need to annotate Greeting class with @Component to make it a bean in the application context.
        assertThrows(NoSuchBeanDefinitionException.class, () -> context.getBean(Greeting.class));
    }

    @Test
    void greeting() {
        Greeting greeting1 = context.getBean("defaultGreeting", Greeting.class);
        assertNotNull(greeting1);
        System.out.println(greeting1);

        Greeting greeting2 = context.getBean("yoGreeting", Greeting.class);
        assertNotNull(greeting2);
        System.out.println(greeting2);
    }
}
