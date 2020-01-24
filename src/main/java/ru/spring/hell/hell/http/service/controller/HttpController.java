package ru.spring.hell.hell.http.service.controller;

import org.springframework.web.bind.annotation.*;
import ru.spring.hell.hell.http.service.model.ExampleRequest;
import ru.spring.hell.hell.http.service.model.ExampleResponse;

@RestController
public class HttpController {

    @GetMapping("/hello")
    public ExampleResponse hello(@RequestParam(name = "name", required = false, defaultValue = "Chian Jou") String name) {
        return new ExampleResponse(name, "Hello");
    }

    @PostMapping("/hello")
    public ExampleResponse hello(@RequestBody ExampleRequest request) {
        return new ExampleResponse(request.getName(), "Hello");
    }
}
