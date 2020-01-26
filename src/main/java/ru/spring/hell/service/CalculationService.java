package ru.spring.hell.service;

import org.springframework.stereotype.Service;
import ru.spring.hell.data.dao.Calculation;
import ru.spring.hell.data.repository.CalculationRepository;

@Service
public class CalculationService {
    private final CalculationRepository repository;

    public CalculationService(CalculationRepository repository) {
        this.repository = repository;
    }

    public void createCalculation(Long firstValue, Long secondValue) {
        Calculation calculation = new Calculation();
        calculation.setFirstValue(firstValue);
        calculation.setSecondValue(secondValue);
        repository.save(calculation);
    }

    public Long calculate(Long id) {
        return repository.calculate(id);
    }

}
