package com.shajedul.personal.statuschamp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.atomic.AtomicLong;

@Controller
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/hello")
    @ResponseBody
    public Greeting sayHello(@RequestParam(name = "name", required = false, defaultValue = "Stranger") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
