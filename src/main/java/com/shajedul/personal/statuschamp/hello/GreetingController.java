package com.shajedul.personal.statuschamp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Spring MVC @Controller returns model object to the view.
 * Therefore we'd need to define @ResponseBody to the resources in order for them
 * to write the object directly to the response body as json/xml.
 *
 * Using @RestController we can achieve this out of the box.
 *
  */
@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/hello")
    public Greeting sayHello(@RequestParam(name = "name", required = false, defaultValue = "Stranger") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/")
    public String index() {
        return "Greetings from Statuschamp!";
    }
}
