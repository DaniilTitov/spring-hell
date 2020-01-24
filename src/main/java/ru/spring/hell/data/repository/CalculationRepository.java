package ru.spring.hell.data.repository;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.spring.hell.data.dao.Calculation;

@Repository
public interface CalculationRepository extends CrudRepository<Calculation, Long> {
    @Procedure(name = "calculate")
    Long calculate(@Param("calculation_id") Long calculation_id);
}
