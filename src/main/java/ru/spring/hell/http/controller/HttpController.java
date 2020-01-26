package ru.spring.hell.http.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.spring.hell.data.Person;
import ru.spring.hell.http.model.CalculationRequest;
import ru.spring.hell.http.model.CalculationResponse;
import ru.spring.hell.http.model.PersonRequest;
import ru.spring.hell.http.model.PersonResponse;
import ru.spring.hell.service.CalculationService;
import ru.spring.hell.service.PersonService;

import static java.lang.String.valueOf;
import static java.util.Objects.isNull;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@AllArgsConstructor
public class HttpController {

    private final CalculationService calculationService;
    private final PersonService personService;

    @PostMapping("/calculation")
    public CalculationResponse calculate(@RequestBody CalculationRequest request) {
        if (isNull(request.getFirstValue()) || isNull(request.getSecondValue())) {
            throw new ResponseStatusException(NOT_FOUND, "Foo Not Found");
        }

        calculationService.createCalculation(request.getFirstValue(), request.getSecondValue());
        return new CalculationResponse("Success");
    }

    @GetMapping("/calculation")
    public CalculationResponse calculate(@RequestParam(name = "id") Long id) {
        return new CalculationResponse(valueOf(calculationService.calculate(id)));
    }

    @PostMapping("/person")
    public PersonResponse save(@RequestBody PersonRequest request) {
        Person person = Person.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .build();

        Person saved = personService.save(person);
        return PersonResponse.builder()
                .description("Successfully saved. Id = " + saved.getId())
                .build();
//        5e2b1f290747b64698aab2fb
    }

    @GetMapping("/person")
    public PersonResponse get(@RequestParam(name = "id") String id) {
        Person person = personService.get(id);
        return PersonResponse.builder()
                .description("Successfully found. Id = " + person.getId() + ", First name = " + person.getFirstName())
                .build();
//        5e2b1f290747b64698aab2fb
    }
}
