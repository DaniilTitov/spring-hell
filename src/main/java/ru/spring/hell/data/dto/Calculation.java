package ru.spring.hell.data.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.ParameterMode.IN;
import static javax.persistence.ParameterMode.OUT;

@Entity
@Table(name = "calculation")
@NamedStoredProcedureQuery(name = "calculate",
        procedureName = "public.calculate_function",
        parameters = {
                @StoredProcedureParameter(mode = IN, name = "calculation_id", type = Long.class),
                @StoredProcedureParameter(mode = OUT, name = "res", type = Long.class)
        })
@Data
@NoArgsConstructor
public class Calculation {

    @Id
    @GeneratedValue
    private Long id;

    private Long firstValue;
    private Long secondValue;
}
