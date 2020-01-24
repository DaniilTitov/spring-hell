package ru.spring.hell.http.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.spring.hell.http.model.ExampleRequest;
import ru.spring.hell.http.model.ExampleResponse;
import ru.spring.hell.http.service.HttpService;

import static java.lang.String.valueOf;
import static java.util.Objects.isNull;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
public class HttpController {

    private final HttpService service;

    public HttpController(HttpService service) {
        this.service = service;
    }

    @GetMapping("/hello")
    public ExampleResponse hello(@RequestParam(name = "id") Long id) {
        return new ExampleResponse(valueOf(service.calculate(id)));
    }

    @PostMapping("/hello")
    public ExampleResponse hello(@RequestBody ExampleRequest request) {
        if (isNull(request.getFirstValue()) || isNull(request.getSecondValue())) {
            throw new ResponseStatusException(NOT_FOUND, "Foo Not Found");
        }

        service.createCalculation(request.getFirstValue(), request.getSecondValue());
        return new ExampleResponse("Success");
    }
}
