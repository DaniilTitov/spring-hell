package ru.spring.hell.http.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.spring.hell.http.model.CalculationRequest;
import ru.spring.hell.http.model.CalculationResponse;
import ru.spring.hell.service.CalculationService;

import javax.transaction.Transactional;

import static java.lang.String.valueOf;
import static java.util.Objects.isNull;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@AllArgsConstructor
public class CalculationController {

    private final CalculationService calculationService;

    @PostMapping("/calculation")
    public CalculationResponse calculate(@RequestBody CalculationRequest request) {
        if (isNull(request.getFirstValue()) || isNull(request.getSecondValue())) {
            throw new ResponseStatusException(NOT_FOUND, "Foo Not Found");
        }

        calculationService.createCalculation(request.getFirstValue(), request.getSecondValue());
        return new CalculationResponse("Success");
    }

    @GetMapping("/calculation")
    @Transactional
    public CalculationResponse calculate(@RequestParam(name = "id") Long id) {
        return new CalculationResponse(valueOf(calculationService.calculate(id)));
    }
}
